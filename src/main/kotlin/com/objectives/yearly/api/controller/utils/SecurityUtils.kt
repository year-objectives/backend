package com.objectives.yearly.api.controller.utils

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

@Component
class SecurityUtils {

    fun getCurrentUsername(): String {
        val auth = SecurityContextHolder.getContext().authentication
        return auth.name
    }

    fun getCurrentUser(): UserDetails {
        val auth = SecurityContextHolder.getContext().authentication
        return auth.principal as UserDetails
    }
}