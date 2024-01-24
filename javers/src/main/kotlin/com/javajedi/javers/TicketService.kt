package com.javajedi.javers

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TicketService(
        private val ticketRepository: TicketRepository
) {

    fun findAll(): List<Ticket> = ticketRepository.findAll()

    fun saveTicket(name: String, price: Double, quantity: Int) {
        val id = ticketRepository.selectNextIdVal()
        ticketRepository.save(
                Ticket(id, name, price, quantity)
        )
    }

    fun updateTicket(id: Int, name: String, price: Double, quantity: Int) {
        val ticket = ticketRepository.findByIdOrNull(id) ?: throw IllegalArgumentException()
        ticket.also {
            it.name = name
            it.price = price
            it.quantity = quantity
        }
        ticketRepository.save(ticket)
    }

    fun deleteTicketById(id: Int) {
        ticketRepository.deleteById(id)
    }

}