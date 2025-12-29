package com.objectives.yearly.domain.service

import com.objectives.yearly.api.dto.requests.auth.UserLoginDto
import com.objectives.yearly.api.dto.requests.auth.UserRefreshDto
import com.objectives.yearly.api.dto.requests.auth.UserRegisterDto
import com.objectives.yearly.api.dto.responses.AuthenticatedDto
import com.objectives.yearly.domain.UserUnauthorizedException
import com.objectives.yearly.domain.UserAlreadyExistsException
import com.objectives.yearly.domain.mapper.UserMapper
import com.objectives.yearly.infrastructure.auth.AccessTokenService
import com.objectives.yearly.infrastructure.auth.RefreshTokenService
import com.objectives.yearly.infrastructure.database.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


@Service
class AuthenticationService(
    private val userRepository: UserRepository,
    private val accessTokenService: AccessTokenService,
    private val refreshTokenService: RefreshTokenService,
    private val userMapper: UserMapper,
    private val authenticationManager: AuthenticationManager
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    fun register(userRegisterDto: UserRegisterDto) {
        require(!userRepository.existsByUsernameOrEmail(userRegisterDto.username, userRegisterDto.email)) {
            throw UserAlreadyExistsException("User already exists")
        }

        val user = userMapper.toModel(userRegisterDto)

        userRepository.save(user)
    }

    fun login(userLoginDto: UserLoginDto): AuthenticatedDto {
        val user = userRepository.findByUsername(userLoginDto.username)
            ?: throw UserUnauthorizedException("Unauthorized user")

        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(userLoginDto.username, userLoginDto.password)
        )

        return AuthenticatedDto(
            authToken = accessTokenService.generateToken(user.resourceId),
            refreshToken = refreshTokenService.generateToken(user.resourceId)
        )
    }

    fun refreshAuthToken(userRefreshDto: UserRefreshDto): AuthenticatedDto {
        val userId = refreshTokenService.validateAndGetUserId(userRefreshDto.refreshToken)
            ?: throw UserUnauthorizedException("Unauthorized user")

        refreshTokenService.invalidateToken(userRefreshDto.refreshToken)

        return AuthenticatedDto(
            authToken = accessTokenService.generateToken(userId),
            refreshToken = refreshTokenService.generateToken(userId)
        )
    }

    fun logout(userRefreshDto: UserRefreshDto) {
        refreshTokenService.invalidateToken(userRefreshDto.refreshToken)
    }
}