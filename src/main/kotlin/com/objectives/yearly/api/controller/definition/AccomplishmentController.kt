package com.objectives.yearly.api.controller.definition

import com.objectives.yearly.api.controller.utils.HttpHelpers
import com.objectives.yearly.api.dto.requests.AccomplishmentRequestDto
import com.objectives.yearly.api.dto.requests.ObjectiveRequestDto
import com.objectives.yearly.api.dto.responses.AccomplishmentResponseDto
import com.objectives.yearly.api.dto.responses.ObjectiveResponseDto
import com.objectives.yearly.domain.service.ObjectiveService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
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

@Tag(name = "Accomplishment Api", description = "The API to handle Accomplishment Resource.")
@RequestMapping(HttpHelpers.ACCOMPLISHMENTS)
@SecurityRequirement(name = "bearerAuth")
interface AccomplishmentController {

    @Operation(
        summary = "Create new accomplishment",
        description = "Create new accomplishment - objective specific"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Accomplishment created"),
            ApiResponse(responseCode = "400", description = "Bad Request"),
            ApiResponse(responseCode = "500", description = "Internal Server Error")
        ]
    )
    @PostMapping
    fun registerAccomplishment(@RequestBody @Valid accomplishment: AccomplishmentRequestDto): ResponseEntity<AccomplishmentResponseDto>

    @Operation(
        summary = "Get current accomplishments",
        description = "Get current accomplishments - objective specific"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Current accomplishments"),
            ApiResponse(responseCode = "500", description = "Internal Server Error")
        ]
    )
    @GetMapping("/current")
    fun getCurrentByObjective(@RequestParam objectiveId: UUID): List<AccomplishmentResponseDto>
}