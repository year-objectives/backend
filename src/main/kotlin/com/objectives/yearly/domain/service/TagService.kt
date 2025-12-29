package com.objectives.yearly.domain.service

import com.objectives.yearly.api.dto.requests.TagRequestDto
import com.objectives.yearly.api.dto.responses.TagResponseDto
import com.objectives.yearly.domain.mapper.TagMapper
import com.objectives.yearly.infrastructure.database.repository.TagRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class TagService(
    val repository: TagRepository,
    val mapper: TagMapper,
    val userService: UserService) {

    fun getAll(): List<TagResponseDto> {
        val currentUser = userService.getCurrentUser()
        return mapper.toApi(repository.findByUser(currentUser))
    }

    fun registerNew(requestDto: TagRequestDto): TagResponseDto {
        val currentUser = userService.getCurrentUser()

        if(repository.existsByNameAndUserResourceId(requestDto.name, currentUser.resourceId))
            throw UnsupportedOperationException("User already has a tag with this name")

        val tag = mapper.toModel(requestDto, currentUser)

        val savedTag = repository.save(tag)
        return mapper.toApi(savedTag)
    }

}
