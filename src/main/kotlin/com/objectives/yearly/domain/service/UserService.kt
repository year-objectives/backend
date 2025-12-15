package com.objectives.yearly.domain.service

import com.objectives.yearly.api.dto.views.UserView
import com.objectives.yearly.domain.UserNotFoundException
import com.objectives.yearly.domain.mapper.UserMapper
import com.objectives.yearly.infrastructure.database.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository, val mapper: UserMapper) {

    fun findByUsername(username: String): UserView {
        return userRepository.findByUsername(username)
            ?.let { mapper.toView(it) }
            ?: throw UserNotFoundException(username,"User not found")
    }
}
    
