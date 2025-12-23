package com.objectives.yearly.api.dto.responses

import java.util.*

data class ObjectiveResponseDto(val id: UUID, val name: String, val type: String,
                                val reversible: Boolean, val targetAmount: Int)


