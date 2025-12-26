package com.objectives.yearly.domain.entity

import com.objectives.yearly.domain.entity.utils.DateTypeRange
import com.objectives.yearly.domain.entity.utils.DateUtils
import java.time.Instant

enum class ObjectiveType(private val dateTypeRange: DateTypeRange) {
    DAILY(DateUtils.Day()),
    WEEKLY(DateUtils.Week()),
    MONTHLY(DateUtils.Month()),
    YEARLY(DateUtils.Year());

    fun getStartDate(): Instant = dateTypeRange.getStartDate()

    fun getEndDate(): Instant = dateTypeRange.getEndDate()
}