package com.objectives.yearly.domain.mapper

import com.objectives.yearly.api.dto.responses.ObjectiveResponseDto
import com.objectives.yearly.domain.mapper.utils.ApiToModel
import com.objectives.yearly.domain.mapper.utils.ModelToApi
import com.objectives.yearly.infrastructure.database.model.ObjectiveEntity
import org.springframework.stereotype.Component

@Component
class ObjectiveMapper:  ModelToApi<ObjectiveEntity, ObjectiveResponseDto>, ApiToModel<ObjectiveResponseDto, ObjectiveEntity> {

    override fun toModel(dto: ObjectiveResponseDto): ObjectiveEntity {
        TODO()
    }

    override fun toApi(model: ObjectiveEntity): ObjectiveResponseDto {
        return ObjectiveResponseDto(model.resourceId, model.name, model.type.toString(), model.reversible, model.targetAmount)

    }

}
