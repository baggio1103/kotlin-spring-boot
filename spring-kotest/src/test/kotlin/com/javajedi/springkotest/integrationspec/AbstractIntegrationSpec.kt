package com.javajedi.springkotest.integrationspec

import io.kotest.core.extensions.Extension
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.extensions.spring.SpringExtension
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer

@SpringBootTest
abstract class AbstractIntegrationSpec(block: BehaviorSpec.() -> Unit = {}): BehaviorSpec(block) {

    override fun extensions(): List<Extension> {
        return listOf(SpringExtension)
    }

    companion object {
        private val POSTGRES_CONTAINER = PostgreSQLContainer("postgres:15.4-alpine")
        @JvmStatic
        @DynamicPropertySource
        fun dynamicPropertySource(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url") { POSTGRES_CONTAINER.jdbcUrl }
            registry.add("spring.datasource.password") { POSTGRES_CONTAINER.password }
            registry.add("spring.datasource.username") { POSTGRES_CONTAINER.username }
        }
        init {
            POSTGRES_CONTAINER.start()
        }
    }

}