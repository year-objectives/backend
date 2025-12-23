package com.objectives.yearly.api.controller


import com.objectives.yearly.api.dto.requests.auth.UserLoginDto
import com.objectives.yearly.api.dto.requests.auth.UserRefreshDto
import com.objectives.yearly.api.dto.requests.auth.UserRegisterDto
import com.objectives.yearly.api.dto.responses.AuthenticatedDto
import com.objectives.yearly.domain.service.AuthenticationService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthenticationController(
    private val service: AuthenticationService
) {



//    @Operation(
//        summary = "User registration",
//        description = "User registration - returns JWT token"
//    )
//    @ApiResponses(
//        value = [
//            ApiResponse(responseCode = "201", description = "Registration Successful"),
//            ApiResponse(responseCode = "400", description = "Bad Request"),
//            ApiResponse(responseCode = "500", description = "Internal Server Error")
//        ]
//    )
    @PostMapping("/register")
    fun register(@Valid @RequestBody userRegisterDto: UserRegisterDto): ResponseEntity<Nothing> {
        service.register(userRegisterDto)
        return  ResponseEntity.ok().build()
    }

//    @Operation(
//        summary = "User login",
//        description = "User login - returns JWT token"
//    )
//    @ApiResponses(
//        value = [
//            ApiResponse(responseCode = "200", description = "Login Successful"),
//            ApiResponse(responseCode = "400", description = "Bad Request"),
//            ApiResponse(responseCode = "401", description = "Unauthorized"),
//            ApiResponse(responseCode = "500", description = "Internal Server Error")
//        ]
//    )
    @PostMapping("/login")
    fun login(@Valid @RequestBody userLoginDto: UserLoginDto): ResponseEntity<AuthenticatedDto> {
        return ResponseEntity.ok(service.login(userLoginDto))
    }

//    @Operation(
//        summary = "Refresh token",
//        description = "Refresh token"
//    )
//    @ApiResponses(
//        value = [
//            ApiResponse(responseCode = "200", description = "Refresh token"),
//            ApiResponse(responseCode = "400", description = "Bad Request"),
//            ApiResponse(responseCode = "500", description = "Internal Server Error")
//        ]
//    )
    @PostMapping("/refresh-token")
    fun refreshAuthToken(@Valid @RequestBody userRefreshDto: UserRefreshDto): ResponseEntity<AuthenticatedDto> {
        return ResponseEntity.ok(service.refreshAuthToken(userRefreshDto))
    }


//    @Operation(
//        summary = "User logout",
//        description = "User logout"
//    )
//    @ApiResponses(
//        value = [
//            ApiResponse(responseCode = "200", description = "Logout Successful"),
//            ApiResponse(responseCode = "400", description = "Bad Request"),
//            ApiResponse(responseCode = "500", description = "Internal Server Error")
//        ]
//    )
    @PostMapping("/logout")
    fun logout(@Valid @RequestBody userRefreshDto: UserRefreshDto): ResponseEntity<Nothing> {
        service.logout(userRefreshDto)
        return ResponseEntity.ok().build()
    }


}