package org.yearobjectives.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.yearobjectives.AppUtils.ResponseDto;

import java.util.UUID;

@Schema(name = ResponseDto.USER,
        description = "Objective response object",
        type = SchemaType.OBJECT,
        readOnly = true,
        examples = {ResponseDto.Examples.USER})
@JsonInclude(Include.NON_EMPTY)
public record UserDto(@JsonProperty UUID id, @JsonProperty String name) {
            
}

