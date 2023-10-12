package com.javajedi.service

import com.javajedi.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun findAll() = userRepository.getAllUsers()

}