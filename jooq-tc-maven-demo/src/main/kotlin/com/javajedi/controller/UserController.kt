package com.javajedi.controller

import com.javajedi.service.PostService
import com.javajedi.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService,
    private val postService: PostService
) {

    @GetMapping
    fun findAllUsers() = userService.findAll()

    @GetMapping("{id}/posts")
    fun findUserPosts(@PathVariable("id") id: Long) = postService.findUserPosts(id)


}