package org.yearobjectives.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.DefaultValue;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.yearobjectives.AppUtils.ResponseDto;

import java.util.UUID;

@Schema(name = ResponseDto.ACCOMPLISHMENT,
        description = "Accomplishment response object",
        type = SchemaType.OBJECT,
        examples = {ResponseDto.Examples.ACCOMPLISHMENT})
public record AccomplishmentDto(@JsonProperty UUID uuid, @JsonProperty Boolean done, @NotNull(message = "Concluded at can not be null") @JsonProperty("concluded_at") long concludedAt) {
    
}
