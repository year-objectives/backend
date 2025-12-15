package com.objectives.yearly.api.dto.forms

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class UserRegisterForm(
                    @field:NotBlank(message = "User's first name is mandatory")
                    val firstName: String,
                    @field:NotBlank(message = "User's last name is mandatory")
                    val lastName: String,
                    @field:Email(message = "Email must be valid")
                    @field:NotBlank(message = "Email is mandatory")
                    val email: String,
                    @field:NotBlank(message = "Password is mandatory")
                    @field:Size(min = 10, message = "Password must have a min of 10 chars")
                    val password: String,
                    @field:NotBlank(message = "Username is mandatory")
                    @field:Size(min = 3, max = 50, message = "Username must have between 3 and 50 chars")
                    val username: String)