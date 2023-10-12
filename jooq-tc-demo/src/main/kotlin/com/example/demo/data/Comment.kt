package com.example.demo.data

import java.time.LocalDateTime

data class Comment(
    val id: Long,
    val name: String,
    val content: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)