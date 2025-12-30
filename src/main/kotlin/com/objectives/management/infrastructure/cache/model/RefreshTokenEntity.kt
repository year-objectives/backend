package com.objectives.management.infrastructure.cache.model

import java.util.UUID

data class RefreshTokenEntity(
    val userId: UUID,
    val createdAt: Long
)