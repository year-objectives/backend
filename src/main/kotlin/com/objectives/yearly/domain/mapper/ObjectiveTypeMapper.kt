package com.objectives.yearly.domain.mapper

import com.objectives.yearly.domain.entity.ObjectiveType
import org.springframework.stereotype.Component

@Component
class ObjectiveTypeMapper {

    fun toInfrastructure(domainEntity: ObjectiveType): com.objectives.yearly.infrastructure.database.model.ObjectiveType {
        return com.objectives.yearly.infrastructure.database.model.ObjectiveType.valueOf(domainEntity.name)
    }

    fun toDomain(modelEntity: com.objectives.yearly.infrastructure.database.model.ObjectiveType): ObjectiveType {
        return ObjectiveType.valueOf(modelEntity.name)
    }
}