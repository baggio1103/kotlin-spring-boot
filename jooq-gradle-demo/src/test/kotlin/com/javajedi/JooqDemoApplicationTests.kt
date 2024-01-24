package com.javajedi

import com.javajedi.Tables.CARS
import com.javajedi.tables.pojos.Cars
import com.javajedi.tables.records.CarsRecord
import org.assertj.core.api.Assertions.assertThat
import org.jooq.DSLContext
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class JooqDemoApplicationTests {

	@Autowired
	lateinit var dsl: DSLContext

	@Test
	fun loadAllCars() {
		val result = dsl.selectFrom(CARS).fetch()
		result.forEach {
			println("Element: ${it.id} - ${it.name}")
		}
		assertThat(result.size).isEqualTo(9)
	}


	@Test
	fun insertTest() {
		val car = Cars(21, "LAMBORGHINI")
		val carRecord = dsl.newRecord(CARS, car)
		carRecord.store()
		val result = dsl.selectFrom(CARS).fetch()
		assertThat(result.size).isEqualTo(10)
	}


}
