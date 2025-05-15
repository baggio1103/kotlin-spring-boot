package com.atomic.coding.itemservice.controller

import com.atomic.coding.itemservice.domain.Item
import com.atomic.coding.itemservice.service.ItemService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/items")
class ItemController(
    private val itemService: ItemService
) {

    @GetMapping
    fun findItems(): List<Item> {
        Thread.sleep(1000)
        return itemService.findItems()
    }

}