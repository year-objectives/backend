package org.yearobjectives.domain.service.util;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAdjusters;

public class DateUtils {

    private DateUtils(){}

    public static Instant getCurrentWeekStart() {
        return LocalDateTime.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).toInstant(ZoneOffset.UTC);
    }

    public static Instant getCurrentDayStart() {
        return LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT).toInstant(ZoneOffset.UTC);
    }

    public static Instant getCurrentYearStart() {
        return LocalDateTime.of(LocalDateTime.now().getYear(), 1, 1, 0, 0, 0).toInstant(ZoneOffset.UTC);
    }

    public static Instant getCurretMonthStart() {
        return LocalDateTime.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(), 1, 0, 0, 0).toInstant(ZoneOffset.UTC);
    }

}
