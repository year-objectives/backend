package com.objectives.yearly.infrastructure.auth

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.util.*
import javax.crypto.SecretKey

@Service
class AccessTokenService(private val userDetailsService: CustomUserDetailsService) {
    
    @Value("\${jwt.secret}")
    private lateinit var secret: String
    
    @Value("\${jwt.access-expiration}")
    private var accessExpiration: Long = 100000
    
    private val key: SecretKey by lazy {
        Keys.hmacShaKeyFor(secret.toByteArray())
    }
    
    fun generateToken(userId: UUID): String {
        return Jwts.builder()
            .subject(userId.toString())
            .issuedAt(Date())
            .expiration(Date(System.currentTimeMillis() + accessExpiration))
            .signWith(key)
            .compact()
    }

    fun validateToken(token: String): Boolean {
        return !isTokenExpired(token)
    }

    fun getUserId(token: String): String? {
        return extractClaims(token)?.subject
    }
    
    private fun extractClaims(token: String): Claims? {
        return try {
            Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .payload
        } catch (_: Exception) {
            null
        }
    }
    
    private fun isTokenExpired(token: String): Boolean {
        val expiration = extractClaims(token)?.expiration
        return expiration?.before(Date()) ?: true
    }
}
