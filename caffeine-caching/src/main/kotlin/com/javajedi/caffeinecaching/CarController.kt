package com.javajedi.caffeinecaching

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/cars")
class CarController(
    private val carService: CarService
) {

    @GetMapping
    fun cars() = carService.cars()

    @GetMapping("/{id}")
    fun car(@PathVariable("id") id: Int) = carService.carById(id)

}