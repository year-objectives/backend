package com.objectives.yearly.domain.service

import com.objectives.yearly.api.dto.requests.ObjectiveRequestDto
import com.objectives.yearly.api.dto.responses.ObjectiveResponseDto
import com.objectives.yearly.domain.mapper.ObjectiveMapper
import com.objectives.yearly.infrastructure.database.repository.ObjectiveRepository
import org.springframework.stereotype.Service

@Service
class ObjectiveService(
    val repository: ObjectiveRepository,
    val mapper: ObjectiveMapper) {


    fun listAll(): List<ObjectiveResponseDto> {
        return mapper.toApi(repository.findAll())
    }

    fun registerObjective(objective: ObjectiveRequestDto): ObjectiveResponseDto {
        TODO()
    }
}
