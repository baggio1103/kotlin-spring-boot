package com.javajedi.caffeinecaching

import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class CarService {

    private val logger = LoggerFactory.getLogger(CarService::class.java)

    private val cars = listOf(
        Car(1, "Ferrari"),
        Car(2, "Lamborghini"),
        Car(3, "BMW"),
        Car(4, "MASERATI"),
        Car(5, "AUDI"),
        Car(6, "MERCEDES"),
    )

    fun cars(): List<Car> {
        logger.info("Retrieving cars...")
        Thread.sleep(3000)
        return cars
    }

    @Cacheable(cacheNames = ["cars"], key = "#id")
    fun carById(id: Int): Car {
        Thread.sleep(3000)
        return cars.first { it.id == id }
    }

}

data class Car(
    val id: Int,
    val name: String
)