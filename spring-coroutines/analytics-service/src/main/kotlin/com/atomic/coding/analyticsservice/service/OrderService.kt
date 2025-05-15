package com.atomic.coding.analyticsservice.service

import com.atomic.coding.analyticsservice.domain.Order
import kotlinx.coroutines.*
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

// Demo Purpose

@Service
class OrderService(
    private val kafkaSender: KafkaSender
) {

    private val logger = LoggerFactory.getLogger(OrderService::class.java)

    private val scope = CoroutineScope(
        SupervisorJob()
                + Dispatchers.IO
                + CoroutineExceptionHandler { _, exception -> logger.error("Exception in Job", exception) }
    )

    fun saveOrder(order: Order) {
        // validation
        // saving
        // sending notification in the background
        scope.launch {
            kafkaSender.sendMessage(topic = "notification", message = "orderMessage")
        }
    }


}

@Service
class KafkaSender {

    fun sendMessage(topic: String, message: String) {

    }

}