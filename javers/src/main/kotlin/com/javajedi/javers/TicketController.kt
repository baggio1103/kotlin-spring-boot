package com.javajedi.javers

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/tickets")
class TicketController(
    private val ticketService: TicketService
) {

    @GetMapping
    fun findAll(): List<Ticket> = ticketService.findAll()

    @PutMapping("/{id}")
    fun update(@PathVariable("id")id: Int, @RequestBody request: TicketUpdateRequest) {
        ticketService.updateTicket(id, request.name, request.price, request.quantity)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable("id")id: Int) {
        ticketService.deleteTicketById(id)
    }

}