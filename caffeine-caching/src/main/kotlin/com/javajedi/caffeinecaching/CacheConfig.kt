package com.javajedi.caffeinecaching

import com.github.benmanes.caffeine.cache.Caffeine
import org.springframework.cache.CacheManager
import org.springframework.cache.caffeine.CaffeineCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit

@Configuration
class CacheConfig {

    @Bean
    fun caffeine(): Caffeine<Any, Any> {
        return Caffeine
            .newBuilder()
            .expireAfterWrite(300, TimeUnit.SECONDS)
            .initialCapacity(30)
            .recordStats()
    }

    @Bean
    fun cacheManager(caffeine: Caffeine<Any, Any>): CacheManager {
        return CaffeineCacheManager().apply {
            setCacheNames(listOf("cars", "companies"))
            setCaffeine(caffeine)
        }
    }

}