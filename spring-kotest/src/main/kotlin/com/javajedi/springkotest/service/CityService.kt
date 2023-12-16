package com.javajedi.springkotest.service

import com.javajedi.springkotest.model.City
import com.javajedi.springkotest.repository.CityRepository
import org.springframework.stereotype.Service

@Service
class CityService(
    private val cityRepository: CityRepository
) {

    fun save(name: String) {
        val id = cityRepository.nextIdVal()
        cityRepository.save(
            City(id, name)
        )
    }

    fun findAll():List<City> = cityRepository.findAll()

    fun findByName(name: String): City = cityRepository.findByName(name)
        ?: throw IllegalArgumentException("City not found with name: $name")

    fun deleteAll() {
        cityRepository.deleteAll()
    }

}