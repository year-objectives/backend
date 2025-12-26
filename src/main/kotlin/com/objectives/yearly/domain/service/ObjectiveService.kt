package com.objectives.yearly.domain.service

import com.objectives.yearly.api.dto.requests.ObjectiveRequestDto
import com.objectives.yearly.api.dto.responses.ObjectiveResponseDto
import com.objectives.yearly.domain.mapper.ObjectiveMapper
import com.objectives.yearly.infrastructure.database.repository.ObjectiveRepository
import org.springframework.stereotype.Service

@Service
class ObjectiveService(
    val repository: ObjectiveRepository,
    val mapper: ObjectiveMapper,
    val userService: UserService) {


    fun listAll(): List<ObjectiveResponseDto> {
        val currentUser = userService.getCurrentUser()
        return mapper.toApi(repository.findByUser(currentUser))
    }

    fun registerObjective(objective: ObjectiveRequestDto): ObjectiveResponseDto {
        val currentUser = userService.getCurrentUser();
        val objectiveToSave = mapper.toModel(objective, currentUser)
        val savedObjective = repository.save(objectiveToSave)
        return mapper.toApi(savedObjective)
    }
}
