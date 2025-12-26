package com.objectives.yearly.api.controller.definition

import com.objectives.yearly.api.controller.utils.HttpHelpers
import com.objectives.yearly.api.dto.requests.ObjectiveRequestDto
import com.objectives.yearly.api.dto.responses.ObjectiveResponseDto
import com.objectives.yearly.domain.service.ObjectiveService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@Tag(name = "Objective Api", description = "The API to handle Objective Resource.")
@RequestMapping(HttpHelpers.OBJECTIVES)
@SecurityRequirement(name = "bearerAuth")
interface ObjectiveController {

    @Operation(
        summary = "Create new objective",
        description = "Create new objective - user specific"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Objective created"),
            ApiResponse(responseCode = "400", description = "Bad Request"),
            ApiResponse(responseCode = "500", description = "Internal Server Error")
        ]
    )
    @PostMapping
    fun registerObjective(@RequestBody @Valid objective: ObjectiveRequestDto): ResponseEntity<ObjectiveResponseDto>
}