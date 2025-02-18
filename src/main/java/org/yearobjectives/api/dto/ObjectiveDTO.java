package org.yearobjectives.api.dto;

import org.yearobjectives.AppUtils.ResponseDto;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;
import java.util.UUID;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;

@Schema(name = ResponseDto.OBJECTIVE,
        description = "Objective response object",
        type = SchemaType.OBJECT,
        readOnly = true,
        example = ResponseDto.Examples.OBJECTIVE)
public record ObjectiveDto(@JsonProperty UUID id, @JsonProperty ObjectiveTypeDto type, @JsonProperty Boolean reversible, 
                           @JsonProperty("cells") List<ObjectiveMarkerDto> objectiveMarkers) {
            
}

