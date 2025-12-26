package com.objectives.yearly.api.dto.responses

import java.util.*

data class AccomplishmentResponseDto(val id: UUID, val objectiveId: UUID, val doneAt: Long, val done: Boolean)
