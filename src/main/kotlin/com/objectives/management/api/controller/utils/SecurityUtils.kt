package com.objectives.management.api.controller.utils

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class SecurityUtils {

    fun getCurrentUserId(): String {
        val auth = SecurityContextHolder.getContext().authentication
        return auth.name
    }
}