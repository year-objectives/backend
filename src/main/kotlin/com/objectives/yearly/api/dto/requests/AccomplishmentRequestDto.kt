package com.objectives.yearly.api.dto.requests

import com.objectives.yearly.api.dto.utils.OpenApiUtils
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotNull
import java.time.Instant
import java.util.*

@Schema(name = OpenApiUtils.RequestDto.ACCOMPLISHMENT,
    description = "Accomplishment request object",
    type = "object",
    examples = [OpenApiUtils.RequestDtoExamples.ACCOMPLISHMENT]
)
data class AccomplishmentRequestDto(
    @field:Schema(description = "Objective Id", required = true)
    @field:NotNull(message = "Objective Id is required")
    var objectiveId: UUID,

    @field:Schema(description = "If accomplishment is done", defaultValue = "true")
    var done: Boolean = true,

    @field:Schema(description = "Unix timestamp when accomplishment is done(MILLISECONDS)")
    val doneAt: Long? = null,

    @field:Schema(description = "Description")
    val description: String? = null
    )