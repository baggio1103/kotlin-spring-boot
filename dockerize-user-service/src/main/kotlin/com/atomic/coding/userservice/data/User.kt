package com.atomic.coding.userservice.data

import java.time.LocalDateTime

data class User(
    val id: Int,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)