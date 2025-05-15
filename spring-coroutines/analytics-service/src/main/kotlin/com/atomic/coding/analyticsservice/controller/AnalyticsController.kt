package com.atomic.coding.analyticsservice.controller

import com.atomic.coding.analyticsservice.domain.Analytics
import com.atomic.coding.analyticsservice.service.AnalyticsService
import com.atomic.coding.analyticsservice.service.CoroutineAnalyticsService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/analytics")
class AnalyticsController(
    private val analyticsService: AnalyticsService,
    private val coroutineAnalyticsService: CoroutineAnalyticsService
) {

    private val logger = LoggerFactory.getLogger(AnalyticsController::class.java)

    @GetMapping
    fun getAnalytics(): Analytics = analyticsService.getAnalytics()

    @GetMapping("/async")
    fun getAnalyticsAsync(): Analytics = analyticsService.getAnalyticsAsync()

    @GetMapping("/async-exception")
    fun getAnalyticsAsyncExceptionally(): Analytics = analyticsService.getAnalyticsAsyncExceptionally()

    @GetMapping("/async-coroutine")
    fun getAnalyticsCoAsync(): Analytics = coroutineAnalyticsService.getAnalyticsAsync()

    @GetMapping("/async-coroutine/v1")
    fun getAnalyticsCoAsyncV1(): Analytics {
        logger.info("Executing async-coroutine analyticsV1")
        return coroutineAnalyticsService.getAnalyticsAsyncV1()
    }

    @GetMapping("/async-coroutine/v2")
    fun getAnalyticsCoAsyncV2(): Analytics {
        logger.info("Executing async-coroutine analyticsV2")
        return coroutineAnalyticsService.getAnalyticsAsyncV2()
    }

    @GetMapping("/async-coroutine-exceptionally")
    fun getAnalyticsCoAsyncExceptionally(): Analytics = coroutineAnalyticsService.getAnalyticsAsyncExceptionally()

}