package com.baggio

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/items")
class ItemController {

    @GetMapping
    fun items(): List<Item> = listOf(
        Item(1, "Iphone 14 Pro", 899.99),
        Item(2, "Mac Book Air", 1299.99),
        Item(3, "Mac Book Pro", 1399.99),
    )

}