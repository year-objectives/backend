package com.objectives.yearly.api.controller.definition

import com.objectives.yearly.api.controller.utils.HttpHelpers
import com.objectives.yearly.api.dto.requests.ObjectiveRequestDto
import com.objectives.yearly.api.dto.responses.GenericErrorDto
import com.objectives.yearly.api.dto.responses.ObjectiveResponseDto
import com.objectives.yearly.api.dto.utils.OpenApiUtils
import com.objectives.yearly.domain.entity.ObjectiveType
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
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.UUID

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

            ApiResponse(responseCode = "201", description = "Objective created",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = ObjectiveResponseDto::class))]),
            ApiResponse(responseCode = "400", description = "Objective dto validation failed",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.BAD_REQUEST_ERROR))]),
            ApiResponse(responseCode = "401", description = "Unauthorized",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.UNAUTHORIZED_ERROR))]),
            ApiResponse(responseCode = "500", description = "Internal Server Error",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.INTERNAL_SERVER_ERROR))])
        ]
    )
    @PostMapping
    fun registerObjective(@RequestBody @Valid objective: ObjectiveRequestDto): ResponseEntity<ObjectiveResponseDto>

    @Operation(
        summary = "Get All objectives",
        description = "Get All objectives"
    )
    @ApiResponses(
        value = [

            ApiResponse(responseCode = "200", description = "List of objectives",
                content = [Content(mediaType = "application/json", array = ArraySchema(schema = Schema(implementation = ObjectiveResponseDto::class)))]),
            ApiResponse(responseCode = "401", description = "Unauthorized",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.UNAUTHORIZED_ERROR))]),
            ApiResponse(responseCode = "500", description = "Internal Server Error",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.INTERNAL_SERVER_ERROR))])
        ]
    )
    @GetMapping
    fun getAll(
        @Parameter(name = "type", `in` = ParameterIn.QUERY)
        @RequestParam type: ObjectiveType?): List<ObjectiveResponseDto>

    @Operation(
        summary = "Get objective by id",
        description = "Get objective by id"
    )
    @ApiResponses(
        value = [

            ApiResponse(responseCode = "200", description = "Objectives",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = ObjectiveResponseDto::class))]),
            ApiResponse(responseCode = "401", description = "Unauthorized",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.UNAUTHORIZED_ERROR))]),
            ApiResponse(responseCode = "404", description = "Not found",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.NOT_FOUND_ERROR))]),
            ApiResponse(responseCode = "500", description = "Internal Server Error",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.INTERNAL_SERVER_ERROR))])
        ]
    )
    @GetMapping("/{id}")
    fun getById(
        @Parameter(name = "id", `in` = ParameterIn.PATH)
        @PathVariable("id") objectiveId: UUID): ObjectiveResponseDto

    @Operation(
        summary = "Update an objective",
        description = "Update an objective"
    )
    @ApiResponses(
        value = [

            ApiResponse(responseCode = "200", description = "Objective updated",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = ObjectiveResponseDto::class))]),
            ApiResponse(responseCode = "400", description = "Objective dto validation failed",
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
    fun updateObjective(
        @Parameter(name = "id", `in` = ParameterIn.PATH)
        @PathVariable("id") objectiveId: UUID,

        @RequestBody @Valid objective: ObjectiveRequestDto): ObjectiveResponseDto

    @Operation(
        summary = "Delete an objective",
        description = "Delete an objective"
    )
    @ApiResponses(
        value = [

            ApiResponse(responseCode = "200", description = "Objective deleted"),
            ApiResponse(responseCode = "500", description = "Internal Server Error",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.INTERNAL_SERVER_ERROR))])
        ]
    )
    @DeleteMapping("/{id}")
    fun deleteObjective(
        @Parameter(name = "id", `in` = ParameterIn.PATH)
        @PathVariable("id") objectiveId: UUID)
}