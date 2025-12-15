package com.objectives.yearly.api.controller


import com.objectives.yearly.api.dto.forms.UserLoginForm
import com.objectives.yearly.api.dto.forms.UserRegisterForm
import com.objectives.yearly.api.dto.views.AuthResponse
import com.objectives.yearly.domain.service.AuthenticationService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthenticationController(
    private val service: AuthenticationService
) {
    
    @PostMapping("/register")
    fun register(@Valid @RequestBody registerForm: UserRegisterForm): ResponseEntity<AuthResponse> {
        val response = service.register(registerForm)
        return  ResponseEntity.status(HttpStatus.CREATED).body(response)
    }
    
    @PostMapping("/login")
    fun login(@Valid @RequestBody loginForm: UserLoginForm): ResponseEntity<AuthResponse> {
        return ResponseEntity.ok(service.login(loginForm))
    }

}