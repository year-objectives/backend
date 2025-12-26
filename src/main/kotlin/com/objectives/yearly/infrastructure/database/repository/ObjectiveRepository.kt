package com.objectives.yearly.infrastructure.database.repository

import com.objectives.yearly.infrastructure.database.model.ObjectiveEntity
import com.objectives.yearly.infrastructure.database.model.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ObjectiveRepository: JpaRepository<ObjectiveEntity, Long> {

    fun findByUser(currentUser: UserEntity): List<ObjectiveEntity>
    fun findByResourceId(objectiveId: UUID): ObjectiveEntity?

}