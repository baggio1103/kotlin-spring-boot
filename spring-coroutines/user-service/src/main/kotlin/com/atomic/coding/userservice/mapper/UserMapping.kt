package com.atomic.coding.userservice.mapper

import com.atomic.coding.userservice.domain.User
import com.atomic.coding.userservice.repository.UserEntity

fun UserEntity.toUser() = User(
    id = id,
    name = name,
    email = email,
    createdAt = createdAt
)