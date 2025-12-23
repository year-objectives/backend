package com.objectives.yearly.api.dto.requests

import com.objectives.yearly.infrastructure.database.model.ObjectiveType
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class ObjectiveRequestDto(
    @field:NotBlank
    val name: String,
    @field:NotBlank
    val targetAmount: Int,
    @field:NotBlank
    val type: ObjectiveType,
    @field:NotNull
    var reversible: Boolean
    )
