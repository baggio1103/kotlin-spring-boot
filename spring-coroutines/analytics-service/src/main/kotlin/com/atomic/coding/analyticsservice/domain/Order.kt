package com.atomic.coding.analyticsservice.domain

import java.math.BigDecimal
import java.time.LocalDateTime

data class Order(
    val id: Long = 0,
    val userId: Long,
    val itemId: Long,
    val quantity: Int,
    val totalPrice: BigDecimal,
    val orderDate: LocalDateTime = LocalDateTime.now()
)