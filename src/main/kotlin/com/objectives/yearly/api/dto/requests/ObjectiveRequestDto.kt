package com.objectives.yearly.api.dto.requests

import com.objectives.yearly.domain.entity.ObjectiveType
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class ObjectiveRequestDto(
    @field:NotBlank(message = "Name is required")
    val name: String,
    @field:NotBlank(message = "Target amount is required")
    @field:Min(value = 1, message = "Minimum amount required is 1")
    val targetAmount: Int,
    @field:NotBlank(message = "Type is required")
    val type: ObjectiveType,
    @field:NotNull(message = "Reversible is required")
    var reversible: Boolean,
    var tags: List<String>
    )
