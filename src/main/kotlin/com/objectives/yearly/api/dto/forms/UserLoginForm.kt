package com.objectives.yearly.api.dto.forms

import jakarta.validation.constraints.NotBlank

data class UserLoginForm(
    @field:NotBlank
    val password: String,
    @field:NotBlank
    val userName: String)