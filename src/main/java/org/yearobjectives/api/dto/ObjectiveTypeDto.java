package org.yearobjectives.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.yearobjectives.api.dto.exceptions.InvalidObjectiveTypeException;

import java.util.Objects;
import java.util.stream.Stream;

public enum ObjectiveTypeDto {
    DAILY,
    WEEKLY,
    MONTHLY,
    YEARLY;


    @JsonCreator
    public static ObjectiveTypeDto fromString(@JsonProperty("type") final String type) {
        return Stream.of(values())
                .filter(typeDto -> Objects.equals(typeDto.toString().toUpperCase(), type.toUpperCase()))
                .findFirst()
                .orElseThrow(() -> new InvalidObjectiveTypeException("Invalid objective type: " + type));
    }
}