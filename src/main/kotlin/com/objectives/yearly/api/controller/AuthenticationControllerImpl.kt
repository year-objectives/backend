package com.objectives.yearly.api.controller


import com.objectives.yearly.api.controller.definition.AuthenticationController
import com.objectives.yearly.api.dto.requests.auth.UserLoginDto
import com.objectives.yearly.api.dto.requests.auth.UserRefreshDto
import com.objectives.yearly.api.dto.requests.auth.UserRegisterDto
import com.objectives.yearly.api.dto.responses.AuthenticatedDto
import com.objectives.yearly.domain.service.AuthenticationService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthenticationControllerImpl(
    private val service: AuthenticationService
): AuthenticationController {


    override fun register(@Valid @RequestBody userRegisterDto: UserRegisterDto): ResponseEntity<Nothing> {
        service.register(userRegisterDto)
        return ResponseEntity
            .status(HttpStatus.CREATED).build()

    }

    override fun login(@Valid @RequestBody userLoginDto: UserLoginDto): ResponseEntity<AuthenticatedDto> {
        return ResponseEntity.ok(service.login(userLoginDto))
    }

    override fun refreshAuthToken(@Valid @RequestBody userRefreshDto: UserRefreshDto): ResponseEntity<AuthenticatedDto> {
        return ResponseEntity.ok(service.refreshAuthToken(userRefreshDto))
    }

    override fun logout(@Valid @RequestBody userRefreshDto: UserRefreshDto): ResponseEntity<Nothing> {
        service.logout(userRefreshDto)
        return ResponseEntity.ok().build()
    }


}