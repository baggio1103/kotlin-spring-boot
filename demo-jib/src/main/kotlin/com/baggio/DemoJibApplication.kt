package com.baggio

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoJibApplication

fun main(args: Array<String>) {
    runApplication<DemoJibApplication>(*args)
}
