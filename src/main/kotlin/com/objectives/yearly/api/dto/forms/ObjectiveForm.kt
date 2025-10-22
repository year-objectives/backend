package com.objectives.yearly.api.dto.forms

import com.objectives.yearly.infrastructure.database.model.ObjectiveType
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class ObjectiveForm(
    @field:NotBlank
    val name: String,
    @field:NotBlank
    val targetAmount: Int,
    @field:NotBlank
    val type: ObjectiveType,
    @field:NotNull
    val reversible: Boolean
    )
