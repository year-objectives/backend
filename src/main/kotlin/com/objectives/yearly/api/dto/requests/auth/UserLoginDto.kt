package com.objectives.yearly.api.dto.requests.auth

import jakarta.validation.constraints.NotBlank

data class UserLoginDto(
    @field:NotBlank(message = "Password is mandatory")
    val password: String,
    @field:NotBlank(message = "Username is mandatory")
    val username: String)