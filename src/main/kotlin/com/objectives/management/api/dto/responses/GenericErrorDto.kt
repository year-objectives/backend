package com.objectives.management.api.dto.responses

import com.objectives.management.api.dto.utils.OpenApiUtils
import io.swagger.v3.oas.annotations.media.Schema
import java.time.Instant

@Schema(name = OpenApiUtils.ResponseDto.GENERIC_ERROR,
    description = "Generic error response object",
    type = "object",
    readOnly = true
)
data class GenericErrorDto(
    @field:Schema(description = "Unix timestamp epoch time (MILLISECONDS)")
    val timestamp: Long = Instant.now().toEpochMilli(),

    @field:Schema(description = "Error status code (not necessarily equal to HTTP status code)")
    val status: Int,

    @field:Schema(description = "Error summary")
    val error: String,

    @field:Schema(description = "Error message")
    val message: String?,

    @field:Schema(description = "Request path where error occurred")
    val path: String
)