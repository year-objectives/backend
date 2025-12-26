package com.objectives.yearly.api.dto.responses

import com.objectives.yearly.api.dto.utils.OpenApiUtils
import io.swagger.v3.oas.annotations.media.Schema
import java.util.*

@Schema(name = OpenApiUtils.ResponseDto.ACCOMPLISHMENT,
    description = "Accomplishment response object",
    type = "object",
    examples = [OpenApiUtils.ResponseDtoExamples.ACCOMPLISHMENT],
    readOnly = true
)
data class AccomplishmentResponseDto(
    @field:Schema(description = "Id")
    val id: UUID,

    @field:Schema(description = "Linked Objective id")
    val objectiveId: UUID,

    @field:Schema(description = "Unix timestamp when accomplishment is done (MILLISECONDS)")
    val doneAt: Long?,

    @field:Schema(description = "If accomplishment is done")
    val done: Boolean,

    @field:Schema(description = "Description")
    val description: String? = null)
