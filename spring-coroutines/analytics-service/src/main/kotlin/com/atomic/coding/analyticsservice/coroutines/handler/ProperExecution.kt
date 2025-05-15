package com.atomic.coding.analyticsservice.coroutines.handler

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    coroutineScope {

        launch {
            execSuspendOne()
        }

        launch {
            execSuspendTwo()
        }

        launch {
            delay(200)
            error("Error")
        }

        delay(500)
        println("Finished executing coroutine scope")

    }
}

suspend fun execSuspendOne() {
    println("Executing function one")
    repeat(100) {
        delay(100)
        println("Running function one")
    }
    println("Finished function one")
}

suspend fun execSuspendTwo() {
    println("Executing function two")
    repeat(100) {
        delay(100)
        println("Running function one")
    }
    println("Finished function two")
}