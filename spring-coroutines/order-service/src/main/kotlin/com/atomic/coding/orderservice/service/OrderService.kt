package com.atomic.coding.orderservice.service

import com.atomic.coding.orderservice.domain.Order
import com.atomic.coding.orderservice.mapper.toOrder
import com.atomic.coding.orderservice.repository.OrderRepository
import org.springframework.stereotype.Service


@Service
class OrderService(
    private val orderRepository: OrderRepository
) {

    fun findOrders(): List<Order> = orderRepository.findAll().map { it.toOrder() }

}