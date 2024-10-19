package com.atomic.coding.userservice.data

data class UserRequest(
    val username: String,
    val password: String,
    val email: String,
    val firstName: String,
    val lastName: String
)
