package org.yearobjectives.api.dto;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.yearobjectives.AppUtils.ResponseDto;

import com.fasterxml.jackson.annotation.JsonProperty;

@Schema(name = ResponseDto.OBJECTIVE_MERKER,
        description = "Objective marker response object",
        type = SchemaType.OBJECT,
        example = ResponseDto.Examples.OBJECTIVE_MARKER)
public record ObjectiveMarkerDto(@JsonProperty Boolean done, @JsonProperty("concluded_at") long concludedAt) {
    
}
