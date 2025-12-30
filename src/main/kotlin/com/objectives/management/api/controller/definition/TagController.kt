package com.objectives.management.api.controller.definition

import com.objectives.management.api.controller.utils.HttpHelpers
import com.objectives.management.api.dto.requests.TagRequestDto
import com.objectives.management.api.dto.responses.GenericErrorDto
import com.objectives.management.api.dto.responses.TagResponseDto
import com.objectives.management.api.dto.utils.OpenApiUtils
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
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

@Tag(name = "Tag Api", description = "The API to handle Tag Resource.")
@RequestMapping(HttpHelpers.TAGS)
@SecurityRequirement(name = "bearerAuth")
interface TagController {

    @Operation(
        summary = "Get all tags",
        description = "Get tags that were created by user"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "All tags",
                content = [Content(mediaType = "application/json", array = ArraySchema(schema = Schema(implementation = TagResponseDto::class)))]),
            ApiResponse(responseCode = "401", description = "Unauthorized",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.UNAUTHORIZED_ERROR))]),
            ApiResponse(responseCode = "500", description = "Internal Server Error",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.INTERNAL_SERVER_ERROR))])
        ]
    )
    @GetMapping
    fun getAll(): List<TagResponseDto>

    @Operation(
        summary = "Create new tag",
        description = "Create new tag and links it to user"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "201", description = "Tag created",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = TagResponseDto::class))]),
            ApiResponse(responseCode = "400", description = "Tag dto validation failed",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.BAD_REQUEST_ERROR))]),
            ApiResponse(responseCode = "401", description = "Unauthorized",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.UNAUTHORIZED_ERROR))]),
            ApiResponse(responseCode = "500", description = "Internal Server Error",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.INTERNAL_SERVER_ERROR))])
        ]
    )
    @PostMapping
    fun registerNew(@Valid @RequestBody requestDto: TagRequestDto): ResponseEntity<TagResponseDto>
}