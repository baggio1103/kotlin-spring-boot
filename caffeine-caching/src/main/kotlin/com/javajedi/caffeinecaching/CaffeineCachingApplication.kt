package com.javajedi.caffeinecaching

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@SpringBootApplication
class CaffeineCachingApplication

fun main(args: Array<String>) {
    runApplication<CaffeineCachingApplication>(*args)
}
