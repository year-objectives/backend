package com.objectives.yearly.domain.service

import com.objectives.yearly.domain.UserNotFoundException
import com.objectives.yearly.infrastructure.database.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        return userRepository.findByUsername(username)
            ?: throw UserNotFoundException(username, "User not found")
    }
}