package com.objectives.management.api.controller

import com.objectives.management.api.controller.definition.TagController
import com.objectives.management.api.controller.utils.HttpHelpers
import com.objectives.management.api.dto.requests.TagRequestDto
import com.objectives.management.api.dto.responses.TagResponseDto
import com.objectives.management.domain.service.TagService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
class TagControllerImpl(private val service: TagService): TagController {

    override fun getAll(): List<TagResponseDto> {
        return service.getAll()
    }

    override fun registerNew(requestDto: TagRequestDto): ResponseEntity<TagResponseDto> {
        val newTag =  service.registerNew(requestDto)
        return ResponseEntity
            .created(URI.create(HttpHelpers.OBJECTIVES+"/" + newTag.id))
            .body(newTag)
    }
}