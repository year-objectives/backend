package org.yearobjectives.domain.entity;

import java.time.Instant;

import org.yearobjectives.domain.entity.util.DateUtils;
import org.yearobjectives.domain.entity.util.MarkerTypeDates;

public enum ObjectiveType {

    DAILY(new DateUtils.Day()),
    WEEKLY(new DateUtils.Week()),
    MONTHLY(new DateUtils.Month()),
    YEARLY(new DateUtils.Year());
    
    private final MarkerTypeDates markerTypeDates;

    ObjectiveType(MarkerTypeDates markerTypeDates) {
        this.markerTypeDates = markerTypeDates;
    }

    public Instant getStart() {
        return this.markerTypeDates.getStart();
    }

    public Instant getEnd() {
        return this.markerTypeDates.getEnd();
    }
    
}