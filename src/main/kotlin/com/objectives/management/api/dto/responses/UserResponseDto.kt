package com.objectives.management.api.dto.responses

import com.objectives.management.api.dto.utils.OpenApiUtils
import io.swagger.v3.oas.annotations.media.Schema

@Schema(name = OpenApiUtils.ResponseDto.USER,
    description = "User response object",
    type = "object",
    examples = [OpenApiUtils.ResponseDtoExamples.USER],
    readOnly = true
)
data class UserResponseDto(
    @field:Schema(description = "Full Name")
    val fullName: String,

    @field:Schema(description = "Email Address")
    val email: String,

    @field:Schema(description = "Username")
    val username: String)