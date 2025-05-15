package com.atomic.coding.analyticsservice.client

import com.atomic.coding.analyticsservice.domain.Order
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient

@Service
class OrderClient {

    private val client = RestClient
        .builder()
        .baseUrl("http://localhost:8082")
        .build()

    fun findOrders(): List<Order> {
        return client.get().uri("/orders").retrieve().body(
            object : ParameterizedTypeReference<List<Order>>() {}
        ) ?: emptyList()
    }

}