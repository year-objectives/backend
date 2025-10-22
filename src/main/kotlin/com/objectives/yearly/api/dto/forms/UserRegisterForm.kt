package com.objectives.yearly.api.dto.forms

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class UserRegisterForm(@field:NotBlank
                    val name: String,
                            @field:Email
                    @field:NotBlank
                    val email: String,
                            @field:NotBlank
                    val password: String,
                            @field:NotBlank
                    val userName: String)


fun UserRegisterForm.toLogin(): UserLoginForm {
    return UserLoginForm(userName = this.userName, password = this.password)
}