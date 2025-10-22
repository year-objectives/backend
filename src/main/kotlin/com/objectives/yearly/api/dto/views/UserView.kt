package com.objectives.yearly.api.dto.views

import java.util.UUID

data class UserView(
    val id: UUID,
    val name: String,
    val userName: String,
    val email: String)