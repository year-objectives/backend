package com.objectives.yearly.api.controller

import com.objectives.yearly.api.dto.forms.ObjectiveForm
import com.objectives.yearly.api.dto.views.ObjectiveView
import com.objectives.yearly.domain.service.ObjectiveService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/objectives")
class ObjectiveController(val service: ObjectiveService) {

    @GetMapping
    fun listAll(): List<ObjectiveView> {
        return service.listAll()
    }

    @PostMapping
    fun registerObjective(@RequestBody @Valid objective: ObjectiveForm): ObjectiveView {
        return service.registerObjective(objective)
    }

}