package com.objectives.management.domain.service

import com.objectives.management.api.dto.requests.AccomplishmentRequestDto
import com.objectives.management.api.dto.responses.AccomplishmentResponseDto
import com.objectives.management.domain.ResourceNotFoundException
import com.objectives.management.domain.mapper.AccomplishmentMapper
import com.objectives.management.domain.mapper.ObjectiveTypeMapper
import com.objectives.management.infrastructure.database.model.AccomplishmentEntity
import com.objectives.management.infrastructure.database.repository.AccomplishmentRepository
import com.objectives.management.infrastructure.database.repository.ObjectiveRepository
import com.objectives.management.infrastructure.database.repository.findCurrentByObjective
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*

@Service
class AccomplishmentService(
    val mapper: AccomplishmentMapper,
    val repository: AccomplishmentRepository,
    val objectiveRepository: ObjectiveRepository,
    val objectiveTypeMapper: ObjectiveTypeMapper) {

    fun registerAccomplishment(accomplishmentDto: AccomplishmentRequestDto): AccomplishmentResponseDto {
        val linkedObjective = objectiveRepository.findByResourceId(accomplishmentDto.objectiveId)
            ?: throw ResourceNotFoundException("Objective not found")

        val objectiveType = objectiveTypeMapper.toDomain(linkedObjective.type)

        val accomplishment = AccomplishmentEntity(
            done = accomplishmentDto.done,
            maxPossibleStart = objectiveType.getEndDate().toEpochMilli(),
            objective = linkedObjective,
            minPossibleStart = objectiveType.getStartDate().toEpochMilli(),
            doneAt = accomplishmentDto.doneAt)


        val savedAccomplishment = repository.save(accomplishment)

        return mapper.toApi(savedAccomplishment)
    }

    fun getCurrentByObjective(objectiveId: UUID): List<AccomplishmentResponseDto> {
        return mapper.toApi(repository.findCurrentByObjective(objectiveId, Instant.now().toEpochMilli()))
    }

    fun updateById(accomplishmentId: UUID, accomplishmentDto: AccomplishmentRequestDto): AccomplishmentResponseDto {
        val accomplishment = repository.findByResourceId(accomplishmentId)
            ?: throw ResourceNotFoundException("Accomplishment with id $accomplishmentId not found")

        if(!accomplishment.objective.reversible && accomplishment.done != accomplishmentDto.done)
            throw UnsupportedOperationException("Can't update done state of irreversible objective")

        val doneAt = if(accomplishment.done) accomplishmentDto.doneAt else null
        accomplishment.doneAt = doneAt
        accomplishment.done = accomplishmentDto.done
        accomplishment.description = accomplishmentDto.description

        val savedAccomplishment = repository.save(accomplishment)
        return mapper.toApi(savedAccomplishment)
    }

}
