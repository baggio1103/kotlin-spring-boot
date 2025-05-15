package com.atomic.coding.analyticsservice.coroutines.handler

import kotlinx.coroutines.*

suspend fun main() {
    coroutineScope {
        launch {
            execOne()
        }

        launch {

            println("Executing function two")

            repeat(100) {
                Thread.sleep(100)
                println("Running function one")
            }

            println("Finished function two")

        }

        launch {
            delay(200)
            error("Error")
        }

        delay(500)
        println("Finished executing coroutine scope")
    }

}

fun execOne() {
    println("Executing function one")
    repeat(100) {
        Thread.sleep(100)
        println("Running function one")
    }
    println("Finished function one")
}
