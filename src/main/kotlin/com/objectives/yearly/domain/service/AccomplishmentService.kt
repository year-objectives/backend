package com.objectives.yearly.domain.service

import com.objectives.yearly.api.dto.requests.AccomplishmentRequestDto
import com.objectives.yearly.api.dto.responses.AccomplishmentResponseDto
import com.objectives.yearly.domain.ResourceNotFoundException
import com.objectives.yearly.domain.mapper.AccomplishmentMapper
import com.objectives.yearly.domain.mapper.ObjectiveTypeMapper
import com.objectives.yearly.infrastructure.database.model.AccomplishmentEntity
import com.objectives.yearly.infrastructure.database.repository.AccomplishmentRepository
import com.objectives.yearly.infrastructure.database.repository.ObjectiveRepository
import com.objectives.yearly.infrastructure.database.repository.findCurrentByObjective
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
        val currentTimeStamp = Instant.now().epochSecond

        return mapper.toApi(repository.findCurrentByObjective(objectiveId, currentTimeStamp))
    }

}
