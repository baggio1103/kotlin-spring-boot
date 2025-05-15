package com.atomic.coding.orderservice.repository

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "orders")
data class OrderEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "user_id")
    val userId: Long,

    @Column(name = "item_id")
    val itemId: Long,

    val quantity: Int,

    @Column(name = "total_price")
    val totalPrice: BigDecimal,

    @Column(name = "order_date")
    val orderDate: LocalDateTime = LocalDateTime.now()
)
