package com.objectives.yearly.api.dto.requests

import com.objectives.yearly.api.dto.utils.OpenApiUtils
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank

@Schema(name = OpenApiUtils.RequestDto.TAG,
    description = "Tag request object",
    type = "object",
    examples = [OpenApiUtils.RequestDtoExamples.TAG]
)
data class TagRequestDto(
    @field:Schema(description = "Name", required = true)
    @field:NotBlank(message = "Name is required")
    val name: String
)