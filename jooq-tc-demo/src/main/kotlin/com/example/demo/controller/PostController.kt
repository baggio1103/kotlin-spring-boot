package com.example.demo.controller

import com.example.demo.service.PostService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts")
class PostController(
    private val postService: PostService
) {

    @GetMapping("/{id}")
    fun getPostById(@PathVariable("id") id: Long) = postService.getPostById(id)

    @GetMapping("/{id}/comments")
    fun getPostByIdWithComments(@PathVariable id: Long) = postService.getPostByIdWithComments(id)

}