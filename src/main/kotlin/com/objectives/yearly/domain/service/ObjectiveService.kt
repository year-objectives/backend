package com.objectives.yearly.domain.service

import com.objectives.yearly.api.dto.requests.ObjectiveRequestDto
import com.objectives.yearly.api.dto.responses.ObjectiveResponseDto
import com.objectives.yearly.domain.ResourceNotFoundException
import com.objectives.yearly.domain.entity.ObjectiveType
import com.objectives.yearly.domain.mapper.ObjectiveMapper
import com.objectives.yearly.domain.mapper.ObjectiveTypeMapper
import com.objectives.yearly.infrastructure.database.repository.ObjectiveRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ObjectiveService(
    val repository: ObjectiveRepository,
    val mapper: ObjectiveMapper,
    val userService: UserService,
    val typeMapper: ObjectiveTypeMapper) {

    fun registerObjective(objective: ObjectiveRequestDto): ObjectiveResponseDto {
        val currentUser = userService.getCurrentUser()
        val objectiveToSave = mapper.toModel(objective, currentUser)
        val savedObjective = repository.save(objectiveToSave)
        return mapper.toApi(savedObjective)
    }

    fun getAll(type: ObjectiveType?): List<ObjectiveResponseDto> {
        val currentUser = userService.getCurrentUser()
        val objectives = type?.let { repository.findByUserAndType(currentUser, typeMapper.toInfrastructure(it)) }
            ?: repository.findByUser(currentUser)
        return mapper.toApi(objectives)
    }

    fun getById(objectiveId: UUID): ObjectiveResponseDto {
        val objective = repository.findByResourceId(objectiveId)
            ?: throw ResourceNotFoundException("Objective with id $objectiveId not found")
        return mapper.toApi(objective)
    }

    fun updateById(objectiveId: UUID, objectiveDto: ObjectiveRequestDto): ObjectiveResponseDto {
        val objective = repository.findByResourceId(objectiveId)
            ?: throw ResourceNotFoundException("Object with id $objectiveId not found")

        objective.type = typeMapper.toInfrastructure(objectiveDto.type)
        objective.name = objectiveDto.name
        objective.description = objectiveDto.description
        objective.reversible = objectiveDto.reversible
        objective.targetAmount = objectiveDto.targetAmount

        val savedObjective = repository.save(objective)
        return mapper.toApi(savedObjective)
    }
}
