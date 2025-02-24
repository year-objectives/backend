package org.yearobjectives.api.dto;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.yearobjectives.AppUtils.ResponseDto;

import com.fasterxml.jackson.annotation.JsonProperty;

@Schema(name = ResponseDto.ACCOMPLISHMENT,
        description = "Objective marker response object",
        type = SchemaType.OBJECT,
        examples = {ResponseDto.Examples.ACCOMPLISHMENT})
public record AccomplishmentDto(@JsonProperty Boolean done, @JsonProperty("concluded_at") long concludedAt) {
    
}
