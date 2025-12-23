package com.objectives.yearly.infrastructure.auth

import com.fasterxml.jackson.databind.ObjectMapper
import com.objectives.yearly.infrastructure.cache.model.RefreshTokenEntity
import org.slf4j.LoggerFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Value
import java.util.UUID
import java.util.concurrent.TimeUnit

@Service
class RefreshTokenService(
    private val redisTemplate: RedisTemplate<String, String>,
    private val objectMapper: ObjectMapper
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    companion object {
        private const val REFRESH_TOKEN_PREFIX = "refresh:"
        private const val USER_TOKENS_PREFIX = "user_tokens:"
    }

    @Value("\${jwt.refresh-expiration}")
    private val refreshExpiration: Long = 2592000000
    
    fun generateToken(userId: UUID): String {
        logger.info("Generating token for user {}", userId)
        val tokenId = UUID.randomUUID().toString()
        val tokenData = RefreshTokenEntity(userId, System.currentTimeMillis())

        logger.debug("Setting token with id {} in refresh", tokenId)
        redisTemplate.opsForValue().set(
            "$REFRESH_TOKEN_PREFIX$tokenId",
            objectMapper.writeValueAsString(tokenData),
            refreshExpiration,
            TimeUnit.MILLISECONDS
        )
        logger.debug("Token set in refresh")

        logger.debug("Adding token with id {} in user_tokens", tokenId)
        redisTemplate.opsForSet().add("$USER_TOKENS_PREFIX$userId", tokenId)
        logger.debug("Token add in user_tokens")

        logger.debug("Set expiration user_tokens")
        redisTemplate.expire("$USER_TOKENS_PREFIX$userId", refreshExpiration, TimeUnit.MILLISECONDS)
        logger.debug("Expiration set in user_tokens")

        logger.info("Token for user {} generated with id {}", userId, tokenId)
        return tokenId
    }
    
    fun validateAndGetUserId(tokenId: String): UUID? {
        logger.info("Validating token with id {}", tokenId)
        val data = redisTemplate.opsForValue().get("$REFRESH_TOKEN_PREFIX$tokenId") ?: return null
        logger.debug("User token with id {} retrieved from Redis", tokenId)
        return try {
            val tokenData = objectMapper.readValue(data, RefreshTokenEntity::class.java)
            logger.debug("User token data => ({}) retrieved from Redis", tokenData)
            tokenData.userId
        } catch (e: Exception) {
            logger.debug("Exception deserializing data {}", e.message)
            null
        }
    }
    
    fun invalidateToken(tokenId: String) {
        logger.info("Invalidating token with id {}", tokenId)
        val redisRefreshKey = "$REFRESH_TOKEN_PREFIX$tokenId"
        val data = redisTemplate.opsForValue().get(redisRefreshKey)
        data?.let {
            try {
                val tokenData = objectMapper.readValue(it, RefreshTokenEntity::class.java)
                redisTemplate.opsForSet().remove("$USER_TOKENS_PREFIX${tokenData.userId}", tokenId)
            } catch (e: Exception) {
                logger.debug("Exception deserializing data {}", e.message)
            }
        }

        redisTemplate.delete(redisRefreshKey)
        logger.info("Token invalidated successfully")
    }
    
    fun invalidateAllUserTokens(userId: UUID) {
        logger.info("Invalidating all tokens for user {}", userId)
        val userTokensKey = "$USER_TOKENS_PREFIX$userId"
        val tokenIds = redisTemplate.opsForSet().members(userTokensKey) ?: return

        logger.debug("Deleting refresh tokens for user {} ({})", userId, tokenIds.size)

        tokenIds.forEach { tokenId ->
            redisTemplate.delete("$REFRESH_TOKEN_PREFIX$tokenId")
        }

        logger.debug("Deleting user_tokens for user {}", userId)
        redisTemplate.delete(userTokensKey)
        logger.info("Tokens invalidated successfully")
    }
}