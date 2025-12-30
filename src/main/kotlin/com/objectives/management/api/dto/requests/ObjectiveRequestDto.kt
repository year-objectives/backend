package com.objectives.management.api.dto.requests

import com.objectives.management.api.dto.utils.OpenApiUtils
import com.objectives.management.domain.entity.ObjectiveType
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.util.*

@Schema(name = OpenApiUtils.RequestDto.OBJECTIVE,
    description = "Objective request object",
    type = "object",
    examples = [OpenApiUtils.RequestDtoExamples.OBJECTIVE]
)
data class ObjectiveRequestDto(
    @field:Schema(description = "Name", required = true)
    @field:NotBlank(message = "Name is required")
    val name: String,

    @field:Schema(description = "Amount of accomplishments for this objective", required = true, minimum = "1")
    @field:NotNull(message = "Target amount is required")
    @field:Min(value = 1, message = "Minimum amount required is 1")
    var targetAmount: Int,

    @field:Schema(description = "Type", required = true)
    @field:NotNull(message = "Type is required")
    val type: ObjectiveType,

    @field:Schema(description = "Reversible", defaultValue = "false")
    var reversible: Boolean = false,

    @field:Schema(description = "Description")
    val description: String? = null,

    @field:Schema(description = "Tags")
    var tags: List<UUID> = emptyList())
