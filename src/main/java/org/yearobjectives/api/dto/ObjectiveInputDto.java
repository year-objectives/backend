package org.yearobjectives.api.dto;

import org.yearobjectives.AppUtils.ResponseDto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;

@Schema(name = ResponseDto.OBJECTIVE,
        description = "Objective response object",
        type = SchemaType.OBJECT,
        readOnly = true,
        example = ResponseDto.Examples.OBJECTIVE)
public record ObjectiveInputDto(@NotBlank @JsonProperty ObjectiveTypeDto type,
                                @NotNull @JsonProperty Boolean reversible, 
                                @JsonProperty("cell_amount") @NotEmpty Integer cellAmount) {
            
}
