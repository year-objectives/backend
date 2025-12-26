package com.objectives.yearly.api.dto.requests.auth

import com.objectives.yearly.api.dto.utils.OpenApiUtils
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Schema(name = OpenApiUtils.RequestDto.USER_REGISTER,
    description = "User register request object",
    type = "object",
    examples = [OpenApiUtils.RequestDtoExamples.USER_REGISTER]
)
data class UserRegisterDto(
    @field:Schema(description = "First name", required = true)
    @field:NotBlank(message = "User's first name is mandatory")
    val firstName: String,

    @field:Schema(description = "Last name", required = true)
    @field:NotBlank(message = "User's last name is mandatory")
    val lastName: String,

    @field:Schema(description = "Email", required = true)
    @field:Email(message = "Email must be valid")
    @field:NotBlank(message = "Email is mandatory")
    val email: String,

    @field:Schema(description = "Password", required = true, minimum = "10")
    @field:NotBlank(message = "Password is mandatory")
    @field:Size(min = 10, message = "Password must have a min of 10 chars")
    val password: String,

    @field:Schema(description = "Username", required = true, minimum = "3", maximum = "50")
    @field:NotBlank(message = "Username is mandatory")
    @field:Size(min = 3, max = 50, message = "Username must have between 3 and 50 chars")
    val username: String)