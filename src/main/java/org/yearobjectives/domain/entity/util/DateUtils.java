package org.yearobjectives.domain.entity.util;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;


public class DateUtils {

    public static class Day implements MarkerTypeDates {

        @Override
        public Instant getStart() {
            return LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT).toInstant(ZoneOffset.UTC);
        }

        @Override
        public Instant getEnd() {
            return this.getStart()
            .plus(1, ChronoUnit.DAYS);
        }
    }

    public static class Week implements MarkerTypeDates {

        @Override
        public Instant getStart() {
            return LocalDateTime.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).withHour(0).withMinute(0).withSecond(0).toInstant(ZoneOffset.UTC);
        }

        @Override
        public Instant getEnd() {
            return this.getStart()
            .plus(7, ChronoUnit.DAYS);
        }
    }

    public static class Month implements MarkerTypeDates {

        @Override
        public Instant getStart() {
            return LocalDateTime.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(), 1, 0, 0, 0).toInstant(ZoneOffset.UTC);
        }

        @Override
        public Instant getEnd() {
            return this.getStart()
            .plus(1, ChronoUnit.MONTHS);
        }
    }

    public static class Year implements MarkerTypeDates {

        @Override
        public Instant getStart() {
            return LocalDateTime.of(LocalDateTime.now().getYear(), 1, 1, 0, 0, 0).toInstant(ZoneOffset.UTC);
        }

        @Override
        public Instant getEnd() {
            return this.getStart()
            .plus(1, ChronoUnit.YEARS);
        }
    }

    private DateUtils() {
    }
}
