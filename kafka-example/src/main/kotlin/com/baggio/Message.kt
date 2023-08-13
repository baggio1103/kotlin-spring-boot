package com.baggio

import java.time.LocalDateTime

data class Message(
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
)