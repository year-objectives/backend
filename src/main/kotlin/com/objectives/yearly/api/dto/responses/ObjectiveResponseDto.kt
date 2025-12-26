package com.objectives.yearly.api.dto.responses

import com.objectives.yearly.api.dto.utils.OpenApiUtils
import io.swagger.v3.oas.annotations.media.Schema
import java.util.*

@Schema(name = OpenApiUtils.ResponseDto.OBJECTIVE,
    description = "Objective response object",
    type = "object",
    examples = [OpenApiUtils.ResponseDtoExamples.OBJECTIVE],
    readOnly = true
)
data class ObjectiveResponseDto(
    @field:Schema(description = "Id")
    val id: UUID,

    @field:Schema(description = "Name")
    val name: String,

    @field:Schema(description = "Description")
    val description: String? = null,

    @field:Schema(description = "Type (weekly, daily, ...)")
    val type: String,

    @field:Schema(description = "Reversible")
    val reversible: Boolean,

    @field:Schema(description = "Amount of accomplishments for this objective")
    val targetAmount: Int,

    @field:Schema(description = "Tags")
    var tags: List<TagResponseDto>? = null)


