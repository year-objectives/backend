package com.objectives.management.api.controller.definition

import com.objectives.management.api.controller.utils.HttpHelpers
import com.objectives.management.api.dto.requests.auth.UserLoginDto
import com.objectives.management.api.dto.requests.auth.UserRefreshDto
import com.objectives.management.api.dto.requests.auth.UserRegisterDto
import com.objectives.management.api.dto.responses.AuthenticatedDto
import com.objectives.management.api.dto.responses.GenericErrorDto
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
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Tag(name = "Authentication Api", description = "The API to handle Authentication flow.")
@RequestMapping(HttpHelpers.AUTHENTICATION)
interface AuthenticationController {

    @Operation(
        summary = "User registration",
        description = "User registration - returns JWT token"
    )
    @ApiResponses(
        value = [

            ApiResponse(responseCode = "201", description = "Registration Successful", content = []),
            ApiResponse(responseCode = "400", description = "User registration dto validation failed",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.BAD_REQUEST_ERROR))]),
            ApiResponse(responseCode = "500", description = "Internal Server Error",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.INTERNAL_SERVER_ERROR))])
        ]
    )
    @PostMapping("/register")
    fun register(@Valid @RequestBody userRegisterDto: UserRegisterDto): ResponseEntity<Nothing>


    @Operation(
        summary = "User login",
        description = "User login - returns JWT token"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Login Successful",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = AuthenticatedDto::class))]),
            ApiResponse(responseCode = "400", description = "User login dto validation failed",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.BAD_REQUEST_ERROR))]),
            ApiResponse(responseCode = "500", description = "Internal Server Error",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.INTERNAL_SERVER_ERROR))])
        ]
    )
    @PostMapping("/login")
    fun login(@Valid @RequestBody userLoginDto: UserLoginDto): ResponseEntity<AuthenticatedDto>


    @Operation(
        summary = "Refresh token",
        description = "Refresh token"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Refresh tokens successful",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = AuthenticatedDto::class))]),
            ApiResponse(responseCode = "400", description = "User login dto validation failed",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.BAD_REQUEST_ERROR))]),
            ApiResponse(responseCode = "500", description = "Internal Server Error",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.INTERNAL_SERVER_ERROR))])
        ]
    )
    @PostMapping("/refresh-token")
    fun refreshAuthToken(@Valid @RequestBody userRefreshDto: UserRefreshDto): ResponseEntity<AuthenticatedDto>


    @Operation(
        summary = "User logout",
        description = "User logout"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Logout successful"),
            ApiResponse(responseCode = "400", description = "User logout dto validation failed",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.BAD_REQUEST_ERROR))]),
            ApiResponse(responseCode = "401", description = "Unauthorized",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.UNAUTHORIZED_ERROR))]),
            ApiResponse(responseCode = "500", description = "Internal Server Error",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GenericErrorDto::class, example = OpenApiUtils.ResponseDtoExamples.INTERNAL_SERVER_ERROR))])
        ]
    )
    @SecurityRequirement(name = "bearerAuth")
    @PostMapping("/logout")
    fun logout(@Valid @RequestBody userRefreshDto: UserRefreshDto): ResponseEntity<Nothing>

}