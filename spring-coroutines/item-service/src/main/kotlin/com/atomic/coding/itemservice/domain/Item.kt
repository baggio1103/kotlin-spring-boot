package com.atomic.coding.itemservice.domain

import java.math.BigDecimal
import java.time.LocalDateTime

data class Item(
    val id: Long = 0,
    val name: String,
    val description: String? = null,
    val price: BigDecimal,
    val stock: Int,
    val createdAt: LocalDateTime = LocalDateTime.now()
)