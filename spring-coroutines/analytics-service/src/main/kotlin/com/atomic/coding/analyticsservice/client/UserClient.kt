package com.atomic.coding.analyticsservice.client

import com.atomic.coding.analyticsservice.domain.User
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient

@Service
class UserClient {

    private val client = RestClient
        .builder()
        .baseUrl("http://localhost:8083")
        .build()

    fun findUsers(): List<User> {
        return client.get().uri("/users").retrieve().body(
            object : ParameterizedTypeReference<List<User>>() {}
        ) ?: emptyList()
    }


}