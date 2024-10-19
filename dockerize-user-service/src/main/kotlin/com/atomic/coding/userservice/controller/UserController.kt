package com.atomic.coding.userservice.controller

import com.atomic.coding.userservice.data.User
import com.atomic.coding.userservice.repository.UserRepository
import com.atomic.coding.userservice.repository.toUser
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

    @GetMapping
    fun getUsers(): List<User> = userService.findAll()

    @GetMapping("/{id}")
    fun getUsers(@PathVariable("id") id: Int): User = userService.findById(id)

}

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun findAll(): List<User> = userRepository.findAll().map { it.toUser() }

    fun findById(id: Int): User = userRepository.findById(id)
        .orElseThrow { IllegalArgumentException("User not found with id: [$id]") }
        .toUser()

}
