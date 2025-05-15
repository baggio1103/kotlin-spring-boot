package com.atomic.coding.userservice.service

import com.atomic.coding.userservice.domain.User
import com.atomic.coding.userservice.mapper.toUser
import com.atomic.coding.userservice.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun findUsers(): List<User> = userRepository.findAll().map { it.toUser() }

}