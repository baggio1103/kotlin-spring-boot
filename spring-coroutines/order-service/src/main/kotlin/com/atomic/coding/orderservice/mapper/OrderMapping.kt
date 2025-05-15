package com.atomic.coding.orderservice.mapper

import com.atomic.coding.orderservice.domain.Order
import com.atomic.coding.orderservice.repository.OrderEntity

fun OrderEntity.toOrder() = Order(
    id = id,
    userId = userId,
    itemId = itemId,
    quantity = quantity,
    totalPrice = totalPrice,
)