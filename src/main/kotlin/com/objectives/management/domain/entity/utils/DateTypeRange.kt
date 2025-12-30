package com.objectives.management.domain.entity.utils


import java.time.Instant

interface DateTypeRange {

    fun getStartDate(): Instant

    fun getEndDate(): Instant
}

