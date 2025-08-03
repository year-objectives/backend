package org.yearobjectives.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;


@JsonInclude(Include.NON_EMPTY)
public record AuthDto(@JsonProperty(value = "user_name") @NotBlank String userName, @JsonProperty @NotBlank String password) {
}

