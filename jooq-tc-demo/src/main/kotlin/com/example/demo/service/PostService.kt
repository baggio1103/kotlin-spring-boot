package com.example.demo.service

import com.example.demo.data.Post
import com.example.demo.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class PostService(
    private val postRepository: PostRepository
) {

    fun getPostById(id: Long) = postRepository.getPostById(id)

    fun findUserPosts(id: Long) = postRepository.getUserPosts(id)

    fun getPostByIdWithComments(id: Long): Post = postRepository.getPostByIdWithComments(id)

}