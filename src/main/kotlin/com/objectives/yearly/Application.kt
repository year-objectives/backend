package com.objectives.yearly

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RequestMapping

@SpringBootApplication
class RestServiceApplication

fun main(args: Array<String>) {
    runApplication<RestServiceApplication>(*args)
}
