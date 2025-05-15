package com.atomic.coding.itemservice.repository

import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository: JpaRepository<ItemEntity, Long>