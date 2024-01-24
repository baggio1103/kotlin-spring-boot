package com.javajedi.caffeinecaching

import com.github.benmanes.caffeine.cache.Cache
import org.springframework.cache.CacheManager
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/cache/stats")
class CacheController(
    private val cacheManager: CacheManager
) {

    @GetMapping
    fun cacheStats(): List<CacheInfo> {
        return cacheManager.cacheNames.map { cacheName ->
            val cache = cacheManager.getCache(cacheName)
            val nativeCache = cache?.nativeCache as Cache<*, *>
            val keys = nativeCache.asMap().keys
            val stats = nativeCache.stats()
            CacheInfo(cacheName, keys, stats.toString())
        }
    }

}

data class CacheInfo(
    val name: String,
    val keys: Set<Any>,
    val stats: String
)