package com.example.demo

import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer

abstract class AbstractContainerBaseTest {

    companion object {
        val POSTGRES_CONTAINER: PostgreSQLContainer<*> = PostgreSQLContainer("postgres:15.4-alpine")
            .withExposedPorts(5432)
            .withUsername("test")
            .withPassword("test")

        @JvmStatic
        @DynamicPropertySource
        fun dynamicPropertySource(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url") { POSTGRES_CONTAINER.jdbcUrl }
            registry.add("spring.datasource.password") { POSTGRES_CONTAINER.password }
            registry.add("spring.datasource.username") { POSTGRES_CONTAINER.username }
            println("INFOOO")
        }
    }

    init {
        POSTGRES_CONTAINER.start()
    }

}