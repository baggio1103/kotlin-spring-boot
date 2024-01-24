package com.javajedi

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CarController(
    private val carService: CarService
) {

    @GetMapping
    fun findAllCars(): List<Car> = carService.findAll()

}