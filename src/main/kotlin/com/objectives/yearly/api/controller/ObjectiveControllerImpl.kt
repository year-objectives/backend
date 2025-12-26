package com.objectives.yearly.api.controller

import com.objectives.yearly.api.controller.definition.ObjectiveController
import com.objectives.yearly.api.controller.utils.HttpHelpers
import com.objectives.yearly.api.dto.requests.ObjectiveRequestDto
import com.objectives.yearly.api.dto.responses.ObjectiveResponseDto
import com.objectives.yearly.domain.service.ObjectiveService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
class ObjectiveControllerImpl(private val service: ObjectiveService): ObjectiveController {

    override fun registerObjective(@RequestBody @Valid objective: ObjectiveRequestDto): ResponseEntity<ObjectiveResponseDto> {
        val objective = service.registerObjective(objective)
        return ResponseEntity
            .created(URI.create(HttpHelpers.OBJECTIVES+"/" + objective.id))
            .body(objective)
    }
}