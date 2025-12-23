package com.objectives.yearly.api.dto.responses

data class AuthenticatedDto(
    val authToken: String,
    val refreshTokenId: String)