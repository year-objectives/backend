package com.objectives.yearly.api.controller.definition

import com.objectives.yearly.api.controller.utils.HttpHelpers
import com.objectives.yearly.api.dto.requests.auth.UserLoginDto
import com.objectives.yearly.api.dto.requests.auth.UserRefreshDto
import com.objectives.yearly.api.dto.requests.auth.UserRegisterDto
import com.objectives.yearly.api.dto.responses.AuthenticatedDto
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

@Tag(name = "Authentication Api", description = "The API to handle Authentication flow.")
@RequestMapping(HttpHelpers.AUTHENTICATION)
interface AuthenticationController {

    @Operation(
        summary = "User registration",
        description = "User registration - returns JWT token"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "201", description = "Registration Successful"),
            ApiResponse(responseCode = "400", description = "Bad Request"),
            ApiResponse(responseCode = "500", description = "Internal Server Error")
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
            ApiResponse(responseCode = "200", description = "Login Successful"),
            ApiResponse(responseCode = "400", description = "Bad Request"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "500", description = "Internal Server Error")
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
            ApiResponse(responseCode = "200", description = "Refresh token"),
            ApiResponse(responseCode = "400", description = "Bad Request"),
            ApiResponse(responseCode = "500", description = "Internal Server Error")
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
            ApiResponse(responseCode = "200", description = "Logout Successful"),
            ApiResponse(responseCode = "400", description = "Bad Request"),
            ApiResponse(responseCode = "500", description = "Internal Server Error")
        ]
    )
    @SecurityRequirement(name = "bearerAuth")
    @PostMapping("/logout")
    fun logout(@Valid @RequestBody userRefreshDto: UserRefreshDto): ResponseEntity<Nothing>

}