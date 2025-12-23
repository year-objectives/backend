package com.objectives.yearly.api.dto.requests

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class UserDto(
                    @field:NotBlank(message = "User's first name is mandatory")
                    val firstName: String,
                    @field:NotBlank(message = "User's last name is mandatory")
                    val lastName: String,
                    @field:Email(message = "Email must be valid")
                    @field:NotBlank(message = "Email is mandatory")
                    val email: String,
                    @field:NotBlank(message = "Username is mandatory")
                    @field:Size(min = 3, max = 50, message = "Username must have between 3 and 50 chars")
                    val username: String)