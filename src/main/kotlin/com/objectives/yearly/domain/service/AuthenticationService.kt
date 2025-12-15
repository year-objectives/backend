package com.objectives.yearly.domain.service

import com.objectives.yearly.api.dto.forms.UserLoginForm
import com.objectives.yearly.api.dto.forms.UserRegisterForm
import com.objectives.yearly.api.dto.views.AuthResponse
import com.objectives.yearly.domain.UserAlreadyExistsException
import com.objectives.yearly.domain.UserNotFoundException
import com.objectives.yearly.domain.mapper.UserMapper
import com.objectives.yearly.infrastructure.auth.JwtService
import com.objectives.yearly.infrastructure.database.model.UserEntity
import com.objectives.yearly.infrastructure.database.repository.UserRepository
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


@Service
class AuthenticationService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtService: JwtService,
    private val userMapper: UserMapper,
    private val authenticationManager: AuthenticationManager
) {

    fun register(userRegisterForm: UserRegisterForm): AuthResponse {
        require(!userRepository.existsByUsernameOrEmail(userRegisterForm.username, userRegisterForm.email)) {
            throw UserAlreadyExistsException(userRegisterForm.username, "User already exists")
        }

        val user = userMapper.toModel(userRegisterForm)

        val token = jwtService.generateToken(user.username)

        userRepository.save(user)
        return AuthResponse(
            token = token,
            username = user.username
        )
    }

    fun login(loginForm: UserLoginForm): AuthResponse {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                loginForm.username,
                loginForm.password
            )
        )

        val user = userRepository.findByUsername(loginForm.username)
            ?: throw UserNotFoundException(loginForm.username,"User not found")

        val token = jwtService.generateToken(user.username)

        return AuthResponse(
            token = token,
            username = user.username
        )
    }

}