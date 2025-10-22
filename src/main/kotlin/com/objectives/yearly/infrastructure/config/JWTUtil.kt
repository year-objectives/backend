package com.objectives.yearly.infrastructure.config

import io.jsonwebtoken.Jwts
import org.springframework.stereotype.Component

@Component
class JWTUtil {

    fun generateToken(username: String): String? {
        return Jwts.builder().compact()
    }
}