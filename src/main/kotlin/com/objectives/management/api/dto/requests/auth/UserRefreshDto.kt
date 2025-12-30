package com.objectives.management.api.dto.requests.auth

import com.objectives.management.api.dto.utils.OpenApiUtils
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank

@Schema(name = OpenApiUtils.RequestDto.USER_REFRESH,
    description = "User refresh request object",
    type = "object",
    examples = [OpenApiUtils.RequestDtoExamples.USER_REFRESH]
)
data class UserRefreshDto(
    @field:Schema(description = "User's refresh token", required = true)
    @field:NotBlank(message = "Refresh token is mandatory")
    val refreshToken: String)
