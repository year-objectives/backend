package com.objectives.management.domain.entity.utils

import java.time.DayOfWeek
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneOffset
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalAdjusters

object DateUtils {

    class Day(): DateTypeRange {
        override fun getStartDate(): Instant {
            return LocalDateTime
                .of(LocalDate.now(), LocalTime.MIDNIGHT)
                .toInstant(ZoneOffset.UTC)
        }

        override fun getEndDate(): Instant {
            return getStartDate()
                .plus(1, ChronoUnit.DAYS)
        }
    }

    class Week(): DateTypeRange {
        override fun getStartDate(): Instant {
            return LocalDateTime
                .now()
                .with(TemporalAdjusters
                    .previousOrSame(DayOfWeek.MONDAY))
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .toInstant(ZoneOffset.UTC)
        }

        override fun getEndDate(): Instant {
            return getStartDate()
                .plus(7, ChronoUnit.DAYS)
        }
    }

    class Month(): DateTypeRange {
        override fun getStartDate(): Instant {
            return LocalDateTime
                .of(LocalDateTime.now().year, LocalDateTime.now().month, 1, 0, 0, 0)
                .toInstant(ZoneOffset.UTC)
        }

        override fun getEndDate(): Instant {
            return getStartDate()
                .plus(1, ChronoUnit.MONTHS)
        }
    }

    class Year(): DateTypeRange {
        override fun getStartDate(): Instant {
            return LocalDateTime
                .of(LocalDateTime.now().year, 1, 1, 0, 0, 0)
                .toInstant(ZoneOffset.UTC)
        }

        override fun getEndDate(): Instant {
            return getStartDate()
                .plus(1, ChronoUnit.YEARS)
        }
    }

}