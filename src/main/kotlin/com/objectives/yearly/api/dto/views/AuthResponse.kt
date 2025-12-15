package com.objectives.yearly.api.dto.views

data class AuthResponse(val token: String, val username: String, val expiresIn: Long? = null)