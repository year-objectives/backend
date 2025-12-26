package com.objectives.yearly.domain.entity.utils


import java.time.Instant

interface DateTypeRange {

    fun getStartDate(): Instant

    fun getEndDate(): Instant
}

