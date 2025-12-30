package com.objectives.management.api.controller.definition

import com.objectives.management.api.controller.utils.HttpHelpers
import com.objectives.management.api.dto.requests.AccomplishmentRequestDto
import com.objectives.management.api.dto.responses.AccomplishmentResponseDto
import com.objectives.management.api.dto.responses.GenericErrorDto
import com.objectives.management.api.dto.utils.OpenApiUtils
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

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
            ApiResponse(responseCode = "201", description = "Accomplishment created",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = AccomplishmentResponseDto::class))]),
            ApiResponse(responseCode = "400", description = "Accomplishment dto validation failed",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.BAD_REQUEST_ERROR))]),
            ApiResponse(responseCode = "401", description = "Unauthorized",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.UNAUTHORIZED_ERROR))]),
            ApiResponse(responseCode = "404", description = "Bad Request",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.NOT_FOUND_ERROR))]),
            ApiResponse(responseCode = "500", description = "Internal Server Error",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.INTERNAL_SERVER_ERROR))])
        ]
    )
    @PostMapping
    fun registerAccomplishment(@RequestBody @Valid accomplishment: AccomplishmentRequestDto): ResponseEntity<AccomplishmentResponseDto>

    @Operation(
        summary = "Get current accomplishments",
        description = "Get current accomplishments - objective specific by user"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Current accomplishments",
                content = [Content(mediaType = "application/json", array = ArraySchema(schema = Schema(implementation = AccomplishmentResponseDto::class)))]),
            ApiResponse(responseCode = "401", description = "Unauthorized",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.UNAUTHORIZED_ERROR))]),
            ApiResponse(responseCode = "500", description = "Internal Server Error",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.INTERNAL_SERVER_ERROR))])
        ]
    )
    @GetMapping("/current")
    fun getCurrentByObjective(
        @RequestParam(value = "objective_id", required = true)
        @Parameter(name = "objective_id", `in` = ParameterIn.QUERY, required = true)
        objectiveId: UUID): List<AccomplishmentResponseDto>

    @Operation(
        summary = "Update accomplishment by id",
        description = "Create new accomplishment - objective specific"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "20", description = "Accomplishment updated",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = AccomplishmentResponseDto::class))]),
            ApiResponse(responseCode = "400", description = "Accomplishment dto validation failed",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.BAD_REQUEST_ERROR))]),
            ApiResponse(responseCode = "401", description = "Unauthorized",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.UNAUTHORIZED_ERROR))]),
            ApiResponse(responseCode = "404", description = "Not found",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.NOT_FOUND_ERROR))]),
            ApiResponse(responseCode = "500", description = "Internal Server Error",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.INTERNAL_SERVER_ERROR))])
        ]
    )
    @PutMapping("/{id}")
    fun updateAccomplishment(
        @Parameter(name = "id", `in` = ParameterIn.PATH)
        @PathVariable("id") accomplishmentId: UUID, @RequestBody @Valid accomplishment: AccomplishmentRequestDto): AccomplishmentResponseDto
}