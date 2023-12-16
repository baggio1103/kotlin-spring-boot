package com.javajedi.springkotest.controller

import com.javajedi.springkotest.data.CityRequest
import com.javajedi.springkotest.model.City
import com.javajedi.springkotest.service.CityService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/cities")
class CityController(
    private val cityService: CityService
) {

    @GetMapping
    fun findAll(): List<City> = cityService.findAll()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveCity(@RequestBody cityRequest: CityRequest) {
        cityService.save(cityRequest.name)
    }

}