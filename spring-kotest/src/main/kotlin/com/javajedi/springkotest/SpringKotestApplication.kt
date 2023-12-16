package com.javajedi.springkotest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringKotestApplication

fun main(args: Array<String>) {
    runApplication<SpringKotestApplication>(*args)
}
