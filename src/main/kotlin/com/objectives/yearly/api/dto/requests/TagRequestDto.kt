package com.objectives.yearly.api.dto.requests

import jakarta.validation.constraints.NotBlank

data class TagRequestDto(
    @field:NotBlank(message = "Name is required")
    val name: String
)