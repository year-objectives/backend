package com.objectives.yearly.api.controller

import com.objectives.yearly.api.dto.requests.ObjectiveRequestDto
import com.objectives.yearly.api.dto.responses.ObjectiveResponseDto
import com.objectives.yearly.domain.service.ObjectiveService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/objectives")
class ObjectiveController(private val service: ObjectiveService) {

    @GetMapping
    fun listAll(): List<ObjectiveResponseDto> {
        return service.listAll()
    }

    @PostMapping
    fun registerObjective(@RequestBody @Valid objective: ObjectiveRequestDto): ObjectiveResponseDto {
        return service.registerObjective(objective)
    }

}