package com.objectives.yearly.api.dto.requests.auth

import jakarta.validation.constraints.NotBlank

data class UserRefreshDto(
    @field:NotBlank(message = "Refresh token is mandatory")
    val refreshTokenId: String)
