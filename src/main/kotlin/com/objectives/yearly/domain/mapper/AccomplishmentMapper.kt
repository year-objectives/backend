package com.objectives.yearly.domain.mapper

import com.objectives.yearly.api.dto.responses.AccomplishmentResponseDto
import com.objectives.yearly.domain.mapper.utils.ModelToApi
import com.objectives.yearly.infrastructure.database.model.AccomplishmentEntity
import org.springframework.stereotype.Component

@Component
class AccomplishmentMapper:  ModelToApi<AccomplishmentEntity, AccomplishmentResponseDto> {

    override fun toApi(model: AccomplishmentEntity): AccomplishmentResponseDto {
        return AccomplishmentResponseDto(model.resourceId, model.objective.resourceId, model.doneAt, model.done)
    }

}
