package com.objectives.yearly.api.dto.forms

import jakarta.validation.constraints.NotBlank

data class UserLoginForm(
    @field:NotBlank(message = "Password is mandatory")
    val password: String,
    @field:NotBlank(message = "Username is mandatory")
    val username: String)