package com.objectives.yearly.api.controller.definition

import com.objectives.yearly.api.controller.utils.HttpHelpers
import com.objectives.yearly.api.dto.requests.TagRequestDto
import com.objectives.yearly.api.dto.responses.TagResponseDto
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
            ApiResponse(responseCode = "200", description = "All tags"),
            ApiResponse(responseCode = "500", description = "Internal Server Error")
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
            ApiResponse(responseCode = "200", description = "Created tag"),
            ApiResponse(responseCode = "500", description = "Internal Server Error")
        ]
    )
    @PostMapping
    fun registerNew(@Valid @RequestBody requestDto: TagRequestDto): ResponseEntity<TagResponseDto>
}