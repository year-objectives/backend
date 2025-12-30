package com.objectives.management.api.dto.responses

import com.objectives.management.api.dto.utils.OpenApiUtils
import io.swagger.v3.oas.annotations.media.Schema
import java.util.UUID

@Schema(name = OpenApiUtils.ResponseDto.TAG,
    description = "Tag response object",
    type = "object",
    examples = [OpenApiUtils.ResponseDtoExamples.TAG],
    readOnly = true
)
data class TagResponseDto(
    @field:Schema(description = "Id")
    val id: UUID,

    @field:Schema(description = "Name")
    val name: String)