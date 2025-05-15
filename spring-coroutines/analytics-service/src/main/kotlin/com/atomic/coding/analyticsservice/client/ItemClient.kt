package com.atomic.coding.analyticsservice.client

import com.atomic.coding.analyticsservice.domain.Item
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient

@Service
class ItemClient {

    private val client = RestClient
        .builder()
        .baseUrl("http://localhost:8081")
        .build()

    fun findItems(): List<Item> {
        return client.get().uri("/items").retrieve().body(
            object : ParameterizedTypeReference<List<Item>>() {}
        ) ?: emptyList()
    }

}
