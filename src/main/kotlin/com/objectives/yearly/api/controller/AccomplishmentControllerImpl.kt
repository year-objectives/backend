package com.objectives.yearly.api.controller

import com.objectives.yearly.api.controller.definition.AccomplishmentController
import com.objectives.yearly.api.controller.utils.HttpHelpers
import com.objectives.yearly.api.dto.requests.AccomplishmentRequestDto
import com.objectives.yearly.api.dto.responses.AccomplishmentResponseDto
import com.objectives.yearly.domain.service.AccomplishmentService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.util.UUID

@RestController
class AccomplishmentControllerImpl(private val service: AccomplishmentService): AccomplishmentController {

    override fun registerAccomplishment(@RequestBody @Valid accomplishment: AccomplishmentRequestDto): ResponseEntity<AccomplishmentResponseDto> {
        val accomplishment = service.registerAccomplishment(accomplishment)
        return ResponseEntity
            .created(URI.create(HttpHelpers.OBJECTIVES+"/" + accomplishment.id))
            .body(accomplishment)
    }

    override fun getCurrentByObjective(@RequestParam objectiveId: UUID): List<AccomplishmentResponseDto> {
        return service.getCurrentByObjective(objectiveId)
    }
}