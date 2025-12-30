package com.objectives.management.domain.service

import com.objectives.management.api.dto.requests.TagRequestDto
import com.objectives.management.api.dto.responses.TagResponseDto
import com.objectives.management.domain.mapper.TagMapper
import com.objectives.management.infrastructure.database.repository.TagRepository
import org.springframework.stereotype.Service

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
