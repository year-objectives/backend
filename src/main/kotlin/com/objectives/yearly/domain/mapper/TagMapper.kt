package com.objectives.yearly.domain.mapper

import com.objectives.yearly.api.dto.requests.TagRequestDto
import com.objectives.yearly.api.dto.responses.TagResponseDto
import com.objectives.yearly.domain.mapper.utils.ModelToApi
import com.objectives.yearly.infrastructure.database.model.TagEntity
import com.objectives.yearly.infrastructure.database.model.UserEntity
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
