package com.objectives.yearly.api.controller

import com.objectives.yearly.api.controller.definition.TagController
import com.objectives.yearly.api.controller.utils.HttpHelpers
import com.objectives.yearly.api.dto.requests.TagRequestDto
import com.objectives.yearly.api.dto.responses.TagResponseDto
import com.objectives.yearly.domain.service.TagService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
class TagControllerImpl(private val service: TagService): TagController {

    override fun getAll(): List<TagResponseDto> {
        return service.getAll()
    }

    override fun registerNew(@Valid @RequestBody requestDto: TagRequestDto): ResponseEntity<TagResponseDto> {
        val newTag =  service.registerNew(requestDto)
        return ResponseEntity
            .created(URI.create(HttpHelpers.OBJECTIVES+"/" + newTag.id))
            .body(newTag)
    }
}