package com.atomic.coding.itemservice.mapper

import com.atomic.coding.itemservice.domain.Item
import com.atomic.coding.itemservice.repository.ItemEntity

fun ItemEntity.toItem() = Item(
    id = id,
    name = name,
    price = price,
    stock = stock,
    createdAt = createdAt
)