package org.yearobjectives.api.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema
public enum ObjectiveTypeDto {
    DAILY,
    WEEKLY,
    MONTHLY,
    YEARLY
}