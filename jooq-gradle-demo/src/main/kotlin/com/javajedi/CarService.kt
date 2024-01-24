package com.javajedi

import com.javajedi.tables.Cars.CARS
import org.jooq.DSLContext
import org.springframework.stereotype.Service

@Service
class CarService(
private val dslContext: DSLContext
) {

    fun findAll(): List<Car> {
        return dslContext.selectFrom(CARS).fetch { Car(it.id, it.name) }
    }

}