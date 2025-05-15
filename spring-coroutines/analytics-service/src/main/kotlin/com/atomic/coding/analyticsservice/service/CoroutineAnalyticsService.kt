package com.atomic.coding.analyticsservice.service

import com.atomic.coding.analyticsservice.client.ItemClient
import com.atomic.coding.analyticsservice.client.OrderClient
import com.atomic.coding.analyticsservice.client.UserClient
import com.atomic.coding.analyticsservice.domain.Analytics
import com.atomic.coding.analyticsservice.domain.Item
import com.atomic.coding.analyticsservice.domain.Order
import com.atomic.coding.analyticsservice.domain.User
import kotlinx.coroutines.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CoroutineAnalyticsService(
    private val itemClient: ItemClient,
    private val orderClient: OrderClient,
    private val userClient: UserClient
) {

    private val logger: Logger = LoggerFactory.getLogger(CoroutineAnalyticsService::class.java)

    fun getAnalytics(): Analytics {
        val items = itemClient.findItems()
        val orders = orderClient.findOrders()
        val users = userClient.findUsers()
        return Analytics(
            items = items,
            orders = orders,
            users = users
        )
    }

    fun getAnalyticsAsync(): Analytics = runBlocking {
        val itemsDeferred = async { itemClient.findItems() }

        val ordersDeferred = async { orderClient.findOrders() }

        val users = userClient.findUsers()
        Analytics(
            items = itemsDeferred.await(),
            orders = ordersDeferred.await(),
            users = users
        )
    }

    fun getAnalyticsAsyncV1(): Analytics = runBlocking(Dispatchers.IO) {
        logger.info("Starting")
        val itemsDeferred = async { logger.info("executed items"); itemClient.findItems() }

        val ordersDeferred = async { logger.info("executed orders"); orderClient.findOrders() }

        val users = userClient.findUsers()
        logger.info("executed users")
        Analytics(
            items = itemsDeferred.await(),
            orders = ordersDeferred.await(),
            users = users
        )

    }

    fun getAnalyticsAsyncV2(): Analytics = runBlocking {
        logger.info("Starting")
        val itemsDeferred = async(Dispatchers.IO) { logger.info("executed items"); itemClient.findItems() }

        val ordersDeferred = async(Dispatchers.IO) { logger.info("executed orders"); orderClient.findOrders() }

        val users = userClient.findUsers()
        logger.info("executed users")

        Analytics(
            items = itemsDeferred.await(),
            orders = ordersDeferred.await(),
            users = users
        )
    }

    fun getAnalyticsAsyncExceptionally(): Analytics = runBlocking(Dispatchers.IO) {
        val itemsDeferred = async {
            runCatching<List<Item>> { itemClient.findItems() }.getOrElse { emptyList() }
        }
        val ordersDeferred = async {
            runCatching<List<Order>> { orderClient.findOrders() }.getOrElse { emptyList() }
        }
        val users = runCatching<List<User>> { userClient.findUsers() }.getOrElse { emptyList() }
        Analytics(
            items = itemsDeferred.await(),
            orders = ordersDeferred.await(),
            users = users
        )
    }


    // Anti-Pattern,
    fun getAnalyticsAsyncTest(): Analytics {
        val scope = CoroutineScope(Dispatchers.IO)

        val itemsDeferred = scope.async {
            runCatching<List<Item>> { itemClient.findItems() }.getOrElse { emptyList() }
        }

        val ordersDeferred = scope.async {
            runCatching<List<Order>> { orderClient.findOrders() }.getOrElse { emptyList() }
        }

        val users = runCatching<List<User>> { userClient.findUsers() }.getOrElse { emptyList() }
        return runBlocking {
            Analytics(
                items = itemsDeferred.await(),
                orders = ordersDeferred.await(),
                users = users
            )
        }
    }

    fun getAnalyticsAsyncWithLogging(): Analytics = runBlocking(Dispatchers.IO) {
        val itemsDeferred = async { logger.info("Async Items Call");itemClient.findItems() }
        val ordersDeferred = async { logger.info("Async Orders Call"); orderClient.findOrders() }
        logger.info("Sync Users Call")
        val users = userClient.findUsers()
        Analytics(
            items = itemsDeferred.await(),
            orders = ordersDeferred.await(),
            users = users
        )
    }

}