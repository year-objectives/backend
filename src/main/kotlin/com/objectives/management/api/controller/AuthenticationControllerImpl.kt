package com.objectives.management.api.controller


import com.objectives.management.api.controller.definition.AuthenticationController
import com.objectives.management.api.dto.requests.auth.UserLoginDto
import com.objectives.management.api.dto.requests.auth.UserRefreshDto
import com.objectives.management.api.dto.requests.auth.UserRegisterDto
import com.objectives.management.api.dto.responses.AuthenticatedDto
import com.objectives.management.domain.service.AuthenticationService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthenticationControllerImpl(
    private val service: AuthenticationService
): AuthenticationController {


    override fun register(userRegisterDto: UserRegisterDto): ResponseEntity<Nothing> {
        service.register(userRegisterDto)
        return ResponseEntity
            .status(HttpStatus.CREATED).build()

    }

    override fun login(userLoginDto: UserLoginDto): ResponseEntity<AuthenticatedDto> {
        return ResponseEntity.ok(service.login(userLoginDto))
    }

    override fun refreshAuthToken(userRefreshDto: UserRefreshDto): ResponseEntity<AuthenticatedDto> {
        return ResponseEntity.ok(service.refreshAuthToken(userRefreshDto))
    }

    override fun logout(userRefreshDto: UserRefreshDto): ResponseEntity<Nothing> {
        service.logout(userRefreshDto)
        return ResponseEntity.ok().build()
    }


}