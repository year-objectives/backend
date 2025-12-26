package com.objectives.yearly.domain.mapper

import com.objectives.yearly.api.dto.requests.ObjectiveRequestDto
import com.objectives.yearly.api.dto.responses.ObjectiveResponseDto
import com.objectives.yearly.domain.mapper.utils.ApiToModel
import com.objectives.yearly.domain.mapper.utils.ModelToApi
import com.objectives.yearly.infrastructure.database.model.ObjectiveEntity
import com.objectives.yearly.infrastructure.database.model.ObjectiveType
import com.objectives.yearly.infrastructure.database.model.TagEntity
import com.objectives.yearly.infrastructure.database.model.UserEntity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ObjectiveMapper(
    private val objectiveTypeMapper: ObjectiveTypeMapper,
    private val tagMapper: TagMapper):  ModelToApi<ObjectiveEntity, ObjectiveResponseDto> {

    fun toModel(dto: ObjectiveRequestDto, user: UserEntity, tagsEntity: MutableList<TagEntity>): ObjectiveEntity {
        return ObjectiveEntity(
            name = dto.name,
            type = objectiveTypeMapper.toInfrastructure(dto.type),
            reversible = dto.reversible,
            targetAmount = dto.targetAmount,
            user = user,
            tags = tagsEntity,
            description = dto.description)
    }

    override fun toApi(model: ObjectiveEntity): ObjectiveResponseDto {
        return ObjectiveResponseDto(
            id = model.resourceId,
            name = model.name,
            type = model.type.toString(),
            reversible = model.reversible,
            targetAmount = model.targetAmount,
            tags = tagMapper.toApi(model.tags),
            description = model.description)
    }

}
