package com.objectives.yearly.api.controller

import com.objectives.yearly.api.controller.utils.SecurityUtils
import com.objectives.yearly.api.dto.views.UserView
import com.objectives.yearly.domain.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService, private val securityUtils: SecurityUtils) {

    @GetMapping("/my-area")
    fun retrieveUserInformation(): ResponseEntity<UserView> {
        return ResponseEntity.ok(userService.findByUsername(securityUtils.getCurrentUsername()))
    }

}