package com.atomic.coding.userservice.controller

import com.atomic.coding.userservice.domain.User
import com.atomic.coding.userservice.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

    @GetMapping
    fun findItems(): List<User> {
        Thread.sleep(1000)
        return userService.findUsers()
    }

}