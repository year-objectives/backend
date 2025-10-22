package com.objectives.yearly.domain.mapper

import com.objectives.yearly.api.dto.views.ObjectiveView
import com.objectives.yearly.domain.mapper.utils.ApiToModel
import com.objectives.yearly.domain.mapper.utils.ModelToApi
import com.objectives.yearly.infrastructure.database.model.ObjectiveEntity
import org.springframework.stereotype.Component

@Component
class ObjectiveMapper():  ModelToApi<ObjectiveEntity, ObjectiveView>, ApiToModel<ObjectiveView, ObjectiveEntity> {

    override fun toView(model: ObjectiveEntity): ObjectiveView {
        return ObjectiveView(model.resourceId, model.name, model.type.toString(), model.reversible, model.targetAmount)
    }

    override fun toModel(api: ObjectiveView): ObjectiveEntity {
        TODO()
    }

}
