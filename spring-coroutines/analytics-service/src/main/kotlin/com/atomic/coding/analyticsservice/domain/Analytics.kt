package com.atomic.coding.analyticsservice.domain

data class Analytics(
    val items: List<Item>,
    val users: List<User> = emptyList(),
    val orders: List<Order> = emptyList()
)