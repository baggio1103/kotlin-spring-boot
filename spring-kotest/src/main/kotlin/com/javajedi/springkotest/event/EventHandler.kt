package com.javajedi.springkotest.event

import com.javajedi.springkotest.messages.Ticket
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Service

@Service
class EventHandler {

    @JmsListener(destination = "ticket_queue")
    fun process(ticket: Ticket) {
        println("Handling event: $ticket")
    }

}