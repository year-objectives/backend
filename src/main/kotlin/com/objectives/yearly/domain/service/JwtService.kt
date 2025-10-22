package com.objectives.yearly.domain.service

import com.objectives.yearly.api.dto.forms.UserLoginForm
import org.springframework.stereotype.Service

@Service
class JwtService(){

    fun generateToken(toLogin: UserLoginForm): String {
        return "this is a token"
    }

    fun invalidateToken(token: String) {}

}
