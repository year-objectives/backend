package com.objectives.management.infrastructure.database.repository

import com.objectives.management.infrastructure.database.model.ObjectiveEntityAll
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ObjectiveAllRepository: JpaRepository<ObjectiveEntityAll, Long>
