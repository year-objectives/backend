package com.objectives.management.domain.mapper

import com.objectives.management.domain.entity.ObjectiveType
import org.springframework.stereotype.Component

@Component
class ObjectiveTypeMapper {

    fun toInfrastructure(domainEntity: ObjectiveType): com.objectives.management.infrastructure.database.model.ObjectiveType {
        return com.objectives.management.infrastructure.database.model.ObjectiveType.valueOf(domainEntity.name)
    }

    fun toDomain(modelEntity: com.objectives.management.infrastructure.database.model.ObjectiveType): ObjectiveType {
        return ObjectiveType.valueOf(modelEntity.name)
    }
}