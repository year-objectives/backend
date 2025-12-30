package com.objectives.management.api.dto.responses

import com.objectives.management.api.dto.utils.OpenApiUtils
import io.swagger.v3.oas.annotations.media.Schema

@Schema(name = OpenApiUtils.ResponseDto.AUTHENTICATED,
    description = "Authenticated response object",
    type = "object",
    examples = [OpenApiUtils.ResponseDtoExamples.AUTHENTICATED],
    readOnly = true
)
data class AuthenticatedDto(
    @field:Schema(description = "Low duration authentication token")
    val authToken: String,

    @field:Schema(description = "Refresh token")
    val refreshToken: String)