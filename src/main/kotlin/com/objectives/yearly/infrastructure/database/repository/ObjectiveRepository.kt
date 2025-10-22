package com.objectives.yearly.infrastructure.database.repository

import com.objectives.yearly.infrastructure.database.model.ObjectiveEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ObjectiveRepository: JpaRepository<ObjectiveEntity, Long> {

}