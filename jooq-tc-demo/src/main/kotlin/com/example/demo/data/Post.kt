package com.example.demo.data

import java.time.LocalDateTime

data class Post(
    val id: Long,
    val title: String,
    val content: String,
    val createdBy: User,
    val comments: List<Comment>,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {

    constructor(id: Long, title: String, content: String, createdBy: User) : this(
        id, title, content, createdBy, emptyList(), LocalDateTime.now(), LocalDateTime.now()
    )

}
