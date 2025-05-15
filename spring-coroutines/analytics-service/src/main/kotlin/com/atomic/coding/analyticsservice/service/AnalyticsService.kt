package com.atomic.coding.analyticsservice.service

import com.atomic.coding.analyticsservice.client.ItemClient
import com.atomic.coding.analyticsservice.client.OrderClient
import com.atomic.coding.analyticsservice.client.UserClient
import com.atomic.coding.analyticsservice.domain.Analytics
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
class AnalyticsService(
    private val itemClient: ItemClient,
    private val orderClient: OrderClient,
    private val userClient: UserClient
) {

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

    fun getAnalyticsAsync(): Analytics {
        val itemsFuture = CompletableFuture.supplyAsync { itemClient.findItems() }
        val ordersFuture = CompletableFuture.supplyAsync { orderClient.findOrders() }
        val usersFuture = CompletableFuture.supplyAsync { userClient.findUsers() }

        // Combining Results
        return itemsFuture.thenCompose { items ->
            ordersFuture.thenCompose { orders ->
                usersFuture.thenApply { users ->
                    Analytics(
                        items = items,
                        orders = orders,
                        users = users
                    )
                }
            }
        }.get()
    }

    fun getAnalyticsAsyncExceptionally(): Analytics {
        val itemsFuture = CompletableFuture.supplyAsync { itemClient.findItems() }
            .exceptionally { emptyList() }
        val ordersFuture = CompletableFuture.supplyAsync { orderClient.findOrders() }
            .exceptionally { emptyList() }
        val usersFuture = CompletableFuture.supplyAsync { userClient.findUsers() }
            .handle { users, exception ->
                if (exception != null) {
                    println("Exception: ${exception.message}")
                    emptyList()
                } else users
            }

        // Combining Results
        return itemsFuture.thenCompose { items ->
            ordersFuture.thenCompose { orders ->
                usersFuture.thenApply { users ->
                    Analytics(
                        items = items,
                        orders = orders,
                        users = users
                    )
                }
            }
        }.get()
    }

//    fun getAnalyticsAsync(): Analytics {
//        val itemsFuture = CompletableFuture.supplyAsync { itemClient.findItems() }
//        val ordersFuture = CompletableFuture.supplyAsync { orderClient.findOrders() }
//        val usersFuture = CompletableFuture.supplyAsync { userClient.findUsers() }
//
//        // Waiting for completion
//        CompletableFuture.allOf(itemsFuture, ordersFuture, usersFuture).join()
//
//        // Returning the results
//        return Analytics(
//            items = itemsFuture.get(),
//            orders = ordersFuture.get(),
//            users = usersFuture.get()
//        )
//    }

}