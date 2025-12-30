package com.objectives.management.domain.mapper

import com.objectives.management.api.dto.responses.AccomplishmentResponseDto
import com.objectives.management.domain.mapper.utils.ModelToApi
import com.objectives.management.infrastructure.database.model.AccomplishmentEntity
import org.springframework.stereotype.Component

@Component
class AccomplishmentMapper:  ModelToApi<AccomplishmentEntity, AccomplishmentResponseDto> {

    override fun toApi(model: AccomplishmentEntity): AccomplishmentResponseDto {
        return AccomplishmentResponseDto(model.resourceId, model.objective.resourceId, model.doneAt, model.done)
    }

}
