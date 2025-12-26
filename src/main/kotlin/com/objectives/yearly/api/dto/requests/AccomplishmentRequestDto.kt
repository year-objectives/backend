package com.objectives.yearly.api.dto.requests

import jakarta.validation.constraints.NotNull
import org.springframework.boot.context.properties.bind.DefaultValue
import java.time.Instant
import java.util.*

data class AccomplishmentRequestDto(
    @field:NotNull(message = "Objective Id is required")
    var objectiveId: UUID,
    @DefaultValue(value = arrayOf("true"))
    var done: Boolean = true,
    val doneAt: Long = Instant.now().toEpochMilli()
    )