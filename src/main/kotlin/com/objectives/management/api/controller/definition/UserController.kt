package com.objectives.management.api.controller.definition

import com.objectives.management.api.controller.utils.HttpHelpers
import com.objectives.management.api.dto.requests.UserDto
import com.objectives.management.api.dto.requests.UserPasswordDto
import com.objectives.management.api.dto.responses.GenericErrorDto
import com.objectives.management.api.dto.responses.UserResponseDto
import com.objectives.management.api.dto.utils.OpenApiUtils
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Tag(name = "User Api", description = "The API to handle User Resource.")
@RequestMapping(HttpHelpers.USERS)
@SecurityRequirement(name = "bearerAuth")
interface UserController {

    @Operation(
        summary = "Change user password",
        description = "Change user password"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Password changed"),
            ApiResponse(responseCode = "400", description = "Login dto validation failed",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.BAD_REQUEST_ERROR))]),
            ApiResponse(responseCode = "401", description = "Unauthorized",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.UNAUTHORIZED_ERROR))]),
            ApiResponse(responseCode = "500", description = "Internal Server Error",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.INTERNAL_SERVER_ERROR))]),
        ]
    )
    @PutMapping("/password")
    fun changePassword(@Valid @RequestBody userPasswordDto: UserPasswordDto): ResponseEntity<Nothing>

    @Operation(
        summary = "Update user details",
        description = "Update user details"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Details updated",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = UserResponseDto::class))]),
            ApiResponse(responseCode = "400", description = "Username or email already exists",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.BAD_REQUEST_ERROR))]),
            ApiResponse(responseCode = "401", description = "Unauthorized",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.UNAUTHORIZED_ERROR))]),
            ApiResponse(responseCode = "500", description = "Internal Server Error",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.INTERNAL_SERVER_ERROR))]),
        ]
    )
    @PutMapping("/details")
    fun updateDetails(@Valid @RequestBody userDto: UserDto): ResponseEntity<UserResponseDto>

    @Operation(
        summary = "Get user details",
        description = "Get user details"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "User details",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = UserResponseDto::class))]),
            ApiResponse(responseCode = "401", description = "Unauthorized",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.UNAUTHORIZED_ERROR))]),
            ApiResponse(responseCode = "500", description = "Internal Server Error",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.INTERNAL_SERVER_ERROR))]),
        ]
    )
    @GetMapping("/details")
    fun getDetails(): ResponseEntity<UserResponseDto>

}