package com.objectives.management.api.dto.requests.auth

import com.objectives.management.api.dto.utils.OpenApiUtils
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank

@Schema(name = OpenApiUtils.RequestDto.USER_LOGIN,
    description = "User login request object",
    type = "object",
    examples = [OpenApiUtils.RequestDtoExamples.USER_LOGIN]
)
data class UserLoginDto(
    @field:Schema(description = "User's password", required = true)
    @field:NotBlank(message = "Password is mandatory")
    val password: String,

    @field:Schema(description = "User's username", required = true)
    @field:NotBlank(message = "Username is mandatory")
    val username: String)