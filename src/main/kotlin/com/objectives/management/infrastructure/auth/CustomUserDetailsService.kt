package com.objectives.management.infrastructure.auth

import com.objectives.management.domain.UserNotFoundException
import com.objectives.management.infrastructure.database.repository.UserRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByUsername(username)
            ?: throw UserNotFoundException("User not found")

        return User(user.username, user.password, user.authorities)
    }
}