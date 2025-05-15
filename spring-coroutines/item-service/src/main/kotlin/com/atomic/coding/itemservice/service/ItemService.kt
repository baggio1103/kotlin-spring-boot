package com.atomic.coding.itemservice.service

import com.atomic.coding.itemservice.domain.Item
import com.atomic.coding.itemservice.mapper.toItem
import com.atomic.coding.itemservice.repository.ItemRepository
import org.springframework.stereotype.Service


@Service
class ItemService(
    private val itemRepository: ItemRepository
) {

    fun findItems(): List<Item> = itemRepository.findAll().map { it.toItem() }

}