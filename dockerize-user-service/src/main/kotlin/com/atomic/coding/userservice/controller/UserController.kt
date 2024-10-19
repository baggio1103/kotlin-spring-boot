package com.atomic.coding.userservice.controller

import com.atomic.coding.userservice.data.User
import com.atomic.coding.userservice.data.UserRequest
import com.atomic.coding.userservice.repository.UserEntity
import com.atomic.coding.userservice.repository.UserRepository
import com.atomic.coding.userservice.repository.toUser
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

    @GetMapping
    fun getUsers(): List<User> = userService.findAll()

    @GetMapping("/{id}")
    fun getUsers(@PathVariable("id") id: Int): User = userService.findById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addUser(@RequestBody userRequest: UserRequest) {
        return userService.addUser(
            username = userRequest.username,
            password = userRequest.password,
            email = userRequest.email,
            firstName = userRequest.firstName,
            lastName = userRequest.lastName
        )
    }

}

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun findAll(): List<User> = userRepository.findAll().map { it.toUser() }

    fun findById(id: Int): User = userRepository.findById(id)
        .orElseThrow { IllegalArgumentException("User not found with id: [$id]") }
        .toUser()

    fun addUser(
        username: String,
        password: String,
        email: String,
        firstName: String,
        lastName: String,
    ) {
        userRepository.save(
            UserEntity(
                username = username,
                password = password,
                email = email,
                firstName = firstName,
                lastName = lastName
            )
        )
    }

}
