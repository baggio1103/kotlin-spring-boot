package com.javajedi.service

import com.javajedi.data.Post
import com.javajedi.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class PostService(
    private val postRepository: PostRepository
) {

    fun getPostById(id: Long) = postRepository.getPostById(id)

    fun findUserPosts(id: Long) = postRepository.getUserPosts(id)

    fun getPostByIdWithComments(id: Long): Post = postRepository.getPostByIdWithComments(id)

}