package com.objectives.yearly.api.controller.definition

import com.objectives.yearly.api.controller.utils.HttpHelpers
import com.objectives.yearly.api.dto.requests.UserDto
import com.objectives.yearly.api.dto.requests.auth.UserLoginDto
import com.objectives.yearly.api.dto.responses.UserResponseDto
import io.swagger.v3.oas.annotations.Operation
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
            ApiResponse(responseCode = "200", description = "Password change Successful"),
            ApiResponse(responseCode = "400", description = "Bad Request"),
            ApiResponse(responseCode = "500", description = "Internal Server Error")
        ]
    )
    @PutMapping("/password")
    fun changePassword(@Valid @RequestBody loginDto: UserLoginDto): ResponseEntity<Nothing>

    @Operation(
        summary = "Change user password",
        description = "Change user password"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Password change Successful"),
            ApiResponse(responseCode = "400", description = "Bad Request"),
            ApiResponse(responseCode = "500", description = "Internal Server Error")
        ]
    )
    @PutMapping("/details")
    fun updateDetails(@Valid @RequestBody userDto: UserDto): ResponseEntity<UserResponseDto>

    @GetMapping("/details")
    fun getDetails(): ResponseEntity<UserResponseDto>

}