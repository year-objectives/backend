package org.yearobjectives.api.dto;

import org.yearobjectives.AppUtils.ResponseDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;
import java.util.UUID;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;

@Schema(name = ResponseDto.OBJECTIVE,
        description = "Objective response object",
        type = SchemaType.OBJECT,
        readOnly = true,
        examples = {ResponseDto.Examples.OBJECTIVE})
@JsonInclude(Include.NON_NULL)
public record ObjectiveDto(@JsonProperty UUID id, @JsonProperty ObjectiveTypeDto type, @JsonProperty Boolean reversible) {
            
}

