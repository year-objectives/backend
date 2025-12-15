package com.objectives.yearly.domain.service

import io.jsonwebtoken.Jwts
import org.junit.jupiter.api.Test
import java.util.Base64

class KeyTest {

    @Test
    fun `user can be created`() {
            val key = Jwts.SIG.HS512.key().build()
            val base64Key = Base64.getEncoder().encodeToString(key.encoded)
            println("Your secret key: $base64Key")
    }
}