package com.javajedi.javers

import org.javers.core.Javers
import org.javers.repository.jql.QueryBuilder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/history/tickets")
class CommitHistoryController(
    private val javers: Javers
) {

    @GetMapping
    fun getTicketSnapshots(): String {
        val ticketQuery = QueryBuilder.byClass(Ticket::class.java)
        val snapshots = javers.findSnapshots(ticketQuery.build())
        return javers.jsonConverter.toJson(snapshots)
    }

}