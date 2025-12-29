package com.objectives.yearly.api.controller

import com.objectives.yearly.api.controller.definition.ObjectiveController
import com.objectives.yearly.api.controller.utils.HttpHelpers
import com.objectives.yearly.api.dto.requests.ObjectiveRequestDto
import com.objectives.yearly.api.dto.responses.ObjectiveResponseDto
import com.objectives.yearly.domain.entity.ObjectiveType
import com.objectives.yearly.domain.service.ObjectiveService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.util.UUID

@RestController
class ObjectiveControllerImpl(private val service: ObjectiveService): ObjectiveController {

    override fun registerObjective(objective: ObjectiveRequestDto): ResponseEntity<ObjectiveResponseDto> {
        val objective = service.registerObjective(objective)
        return ResponseEntity
            .created(URI.create(HttpHelpers.OBJECTIVES+"/" + objective.id))
            .body(objective)
    }

    override fun getAll(type: ObjectiveType?): List<ObjectiveResponseDto> {
        return service.getAll(type)
    }

    override fun getById(objectiveId: UUID): ObjectiveResponseDto {
        return service.getById(objectiveId)
    }

    override fun updateObjective(objectiveId: UUID, objective: ObjectiveRequestDto): ObjectiveResponseDto {
        return service.updateById(objectiveId, objective)
    }

    override fun deleteObjective(objectiveId: UUID) {
        service.deleteById(objectiveId)
    }
}