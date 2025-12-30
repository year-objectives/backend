package com.objectives.management.api.controller

import com.objectives.management.api.controller.definition.AccomplishmentController
import com.objectives.management.api.controller.utils.HttpHelpers
import com.objectives.management.api.dto.requests.AccomplishmentRequestDto
import com.objectives.management.api.dto.responses.AccomplishmentResponseDto
import com.objectives.management.domain.service.AccomplishmentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.util.*

@RestController
class AccomplishmentControllerImpl(private val service: AccomplishmentService): AccomplishmentController {

    override fun registerAccomplishment(accomplishment: AccomplishmentRequestDto): ResponseEntity<AccomplishmentResponseDto> {
        val accomplishment = service.registerAccomplishment(accomplishment)
        return ResponseEntity
            .created(URI.create(HttpHelpers.OBJECTIVES+"/" + accomplishment.id))
            .body(accomplishment)
    }

    override fun getCurrentByObjective(objectiveId: UUID): List<AccomplishmentResponseDto> {
        return service.getCurrentByObjective(objectiveId)
    }

    override fun updateAccomplishment(accomplishmentId: UUID, accomplishment: AccomplishmentRequestDto): AccomplishmentResponseDto {
        return service.updateById(accomplishmentId, accomplishment)
    }
}