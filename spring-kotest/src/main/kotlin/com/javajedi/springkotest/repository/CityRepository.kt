package com.javajedi.springkotest.repository

import com.javajedi.springkotest.model.City
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CityRepository : JpaRepository<City, Int> {

    @Query("SELECT nextval('city_id_seq')", nativeQuery = true)
    fun nextIdVal(): Int

    fun findByName(name: String): City?

}