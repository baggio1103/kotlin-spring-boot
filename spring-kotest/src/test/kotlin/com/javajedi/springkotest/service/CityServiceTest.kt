package com.javajedi.springkotest.service

import com.javajedi.springkotest.data.CityRequest
import com.javajedi.springkotest.integrationspec.AbstractIntegrationSpec
import io.kotest.matchers.shouldBe


class CityServiceTest(
        private val cityService: CityService
) : AbstractIntegrationSpec( {


        given("a request to save a new city") {
            val request = CityRequest("Tokio")
            val cities = cityService.findAll()
            `when`("a request is called to save ${request.name}") {
                cityService.save(request.name)
                then("${request.name} must be in the list") {
                    val currentCities = cityService.findAll()
                    val cityName = currentCities.first { it.name == request.name }
                    cityName.name shouldBe request.name
                    cities.size + 1 shouldBe currentCities.size
                }
            }
        }
}

)