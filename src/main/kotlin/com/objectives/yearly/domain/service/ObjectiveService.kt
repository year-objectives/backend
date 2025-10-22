package com.objectives.yearly.domain.service

import com.objectives.yearly.api.dto.forms.ObjectiveForm
import com.objectives.yearly.api.dto.views.ObjectiveView
import com.objectives.yearly.domain.mapper.ObjectiveMapper
import com.objectives.yearly.infrastructure.database.repository.ObjectiveRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ObjectiveService(val repository: ObjectiveRepository, val mapper: ObjectiveMapper) {


    fun listAll(): List<ObjectiveView> {
        return mapper.toView(repository.findAll())
    }

    @Transactional
    fun registerObjective(objective: ObjectiveForm): ObjectiveView {
        TODO()
    }
}
