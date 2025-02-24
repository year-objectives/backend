package org.yearobjectives.api.dto;

import org.yearobjectives.AppUtils.RequestBodies;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;

@Schema(name = RequestBodies.OBJECTIVE,
        description = "Objective response object",
        type = SchemaType.OBJECT,
        examples = {RequestBodies.Examples.OBJECTIVE})
public record ObjectiveInputDto(@NotNull(message = "Key 'type' can not be null") @JsonProperty ObjectiveTypeDto type,
                                @NotNull(message = "Key 'reversible' can not be null") @JsonProperty Boolean reversible,
                                @NotNull(message = "Key 'amount' can not be null") @JsonProperty("amount") Integer cellAmount) {
            
}
