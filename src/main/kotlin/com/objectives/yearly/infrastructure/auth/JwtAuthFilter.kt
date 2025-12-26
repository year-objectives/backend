@file:Suppress("PROPERTY_HIDES_JAVA_FIELD")

package com.objectives.yearly.infrastructure.auth

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.web.servlet.HandlerExecutionChain
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping

@Component
class JwtAuthFilter(
    private val accessTokenService: AccessTokenService,
    private val handlerMapping: RequestMappingHandlerMapping
) : OncePerRequestFilter() {
    
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            val authHeader = request.getHeader("Authorization")
            
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                filterChain.doFilter(request, response)
                return
            }
            
            val token = authHeader.substring(7)

            if (!accessTokenService.validateToken(token)) {
                filterChain.doFilter(request, response)
                return
            }

            val userId = accessTokenService.getUserId(token)

            val authentication = UsernamePasswordAuthenticationToken(
                userId,
                null,
                emptyList()
            )

            SecurityContextHolder.getContext().authentication = authentication
            
        } catch (e: Exception) {
            logger.error("Cannot set user authentication: ${e.message}")
        }
        
        filterChain.doFilter(request, response)
    }

    override fun shouldNotFilter(request: HttpServletRequest): Boolean {
    val path = request.requestURI
    return path.startsWith("/auth/login") || 
            path.startsWith("/auth/register") ||
            path.startsWith("/auth/refresh-token")
    }
}