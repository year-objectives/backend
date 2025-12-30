package com.objectives.management.infrastructure.database.repository

import com.objectives.management.infrastructure.database.model.AccomplishmentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AccomplishmentRepository: JpaRepository<AccomplishmentEntity, Long> {

    fun findByObjectiveResourceIdAndMaxPossibleStartGreaterThanAndMinPossibleStartLessThanEqual(
        resourceId: UUID,
        maxTimestamp: Long,
        minTimestamp: Long
    ): List<AccomplishmentEntity>

    fun findByResourceId(accomplishmentId: UUID): AccomplishmentEntity?
}

fun AccomplishmentRepository.findCurrentByObjective(
    objectiveId: UUID,
    currentTimestamp: Long
): List<AccomplishmentEntity> {
    return findByObjectiveResourceIdAndMaxPossibleStartGreaterThanAndMinPossibleStartLessThanEqual(
        objectiveId,
        currentTimestamp,
        currentTimestamp
    )
}