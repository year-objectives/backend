package com.objectives.management.domain.service

import com.objectives.management.api.controller.utils.SecurityUtils
import com.objectives.management.api.dto.requests.UserDto
import com.objectives.management.api.dto.requests.UserPasswordDto
import com.objectives.management.api.dto.responses.UserResponseDto
import com.objectives.management.domain.UserUniqueFieldTakenException
import com.objectives.management.domain.mapper.UserMapper
import com.objectives.management.infrastructure.auth.RefreshTokenService
import com.objectives.management.infrastructure.database.model.UserEntity
import com.objectives.management.infrastructure.database.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val repository: UserRepository,
    private val mapper: UserMapper,
    private val refreshTokenService: RefreshTokenService,
    private val securityUtils: SecurityUtils) {

    fun changePassword(userPasswordDto: UserPasswordDto) {
        val user = getCurrentUser()

        user.password = mapper.getPasswordEncoded(userPasswordDto.password)

        refreshTokenService.invalidateAllUserTokens(user.resourceId)
        repository.save(user)
    }

    fun userDetails(userDto: UserDto): UserResponseDto {
         when {
            repository.existsByEmail(userDto.email) -> throw UserUniqueFieldTakenException("Email being updated already exists")
            repository.existsByUsername(userDto.username) -> throw UserUniqueFieldTakenException("Username being updated already exists")
        }

        val user = getCurrentUser()

        user.username = userDto.username
        user.email = userDto.email
        user.name = mapper.fullNameConverter(userDto.firstName, userDto.lastName)

        val savedUser = repository.save(user)
        return mapper.toApi(savedUser)
    }

    fun getDetails(): UserResponseDto {
        val user = getCurrentUser()
        return mapper.toApi(user)
    }

    fun getCurrentUser(): UserEntity = repository.findByResourceId(UUID.fromString(securityUtils.getCurrentUserId()))

}