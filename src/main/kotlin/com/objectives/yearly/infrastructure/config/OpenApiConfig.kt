package com.objectives.yearly.infrastructure.config
//
//import io.swagger.v3.oas.annotations.OpenAPIDefinition
//import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
//import io.swagger.v3.oas.annotations.info.Info
//import io.swagger.v3.oas.annotations.security.SecurityRequirement
//import io.swagger.v3.oas.annotations.security.SecurityScheme
//import org.springframework.context.annotation.Configuration
//import org.springframework.context.annotation.Profile
//
//@Configuration
//@Profile("dev")
//@OpenAPIDefinition(
//    info = Info(
//        title = "Yealy data persist API",
//        version = "1.0",
//        description = "API Documentation"
//    ),
//    security = [SecurityRequirement(name = "bearerAuth")] // Apply to all by default
//)
//@SecurityScheme(
//    name = "bearerAuth",
//    type = SecuritySchemeType.HTTP,
//    scheme = "bearer",
//    bearerFormat = "JWT"
//)
//class OpenApiConfig