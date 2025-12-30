package com.objectives.management.domain.mapper

import com.objectives.management.api.dto.requests.TagRequestDto
import com.objectives.management.api.dto.responses.TagResponseDto
import com.objectives.management.domain.mapper.utils.ModelToApi
import com.objectives.management.infrastructure.database.model.TagEntity
import com.objectives.management.infrastructure.database.model.UserEntity
import org.springframework.stereotype.Component

@Component
class TagMapper:  ModelToApi<TagEntity, TagResponseDto> {

    override fun toApi(model: TagEntity): TagResponseDto {
        return TagResponseDto(name = model.name, id = model.resourceId)
    }

    fun toModel(requestDto: TagRequestDto, currentUser: UserEntity): TagEntity {
        return TagEntity(name = requestDto.name, user = currentUser)
    }

}
