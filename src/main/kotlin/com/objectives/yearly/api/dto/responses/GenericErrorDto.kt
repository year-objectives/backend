package com.objectives.yearly.api.dto.responses

import java.time.LocalDateTime

data class GenericErrorDto(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val message: String?,
    val path: String
)