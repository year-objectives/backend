package com.objectives.yearly.infrastructure.auth

import com.objectives.yearly.domain.UserNotFoundException
import com.objectives.yearly.infrastructure.database.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.UUID

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