package com.objectives.yearly.api.dto.requests

import com.objectives.yearly.api.dto.utils.OpenApiUtils
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Schema(name = OpenApiUtils.RequestDto.USER_PASSWORD,
    description = "User update password object",
    type = "object",
    examples = [OpenApiUtils.RequestDtoExamples.USER_PASSWORD]
)
data class UserPasswordDto(
    @field:Schema(description = "User's password", required = true)
    @field:NotBlank(message = "Password is mandatory")
    @field:Size(min = 10, message = "Password must have a min of 10 chars")
    val password: String,)