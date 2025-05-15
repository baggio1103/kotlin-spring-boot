package com.atomic.coding.orderservice.controller

import com.atomic.coding.orderservice.domain.Order
import com.atomic.coding.orderservice.service.OrderService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class OrderController(
    private val orderService: OrderService
) {

    @GetMapping
    fun findItems(): List<Order> {
        Thread.sleep(1000)
        return orderService.findOrders()
    }

}