package com.javajedi.springkotest.intergrationtests

import com.javajedi.springkotest.container.AbstractPostgresContainer
import com.javajedi.springkotest.data.CityRequest
import com.javajedi.springkotest.model.City
import com.javajedi.springkotest.service.CityService
import io.restassured.RestAssured
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.server.LocalServerPort

@SpringBootTest(webEnvironment = RANDOM_PORT)
class CityControllerTest : AbstractPostgresContainer() {

    @Autowired
    lateinit var cityService: CityService

    @LocalServerPort
    lateinit var port: String

    @BeforeEach
    fun setup() {
        RestAssured.baseURI = "http://localhost:$port"
        cityService.deleteAll()
    }

    @Test
    fun `it should return a list of cities`() {
        cityService.save("London")
        val cities = cityService.findAll()
        val response = given()
                .contentType(ContentType.JSON)
                .`when`()
                .get("/api/v1/cities")
                .then()
                .statusCode(200)
                .extract()
                .response()
        val jsonPath = response.jsonPath()
        val cityResponse = jsonPath.getList("", City::class.java)
        Assertions.assertEquals(cityResponse, cities)
    }

    @Test
    fun `it should create a new city`() {
        val cityRequest = CityRequest("Asgard")
        given()
                .header("Content-type", "application/json")
                .and()
                .body(cityRequest).`when`()
                .post("api/v1/cities")
                .then()
                .statusCode(201)
    }

}