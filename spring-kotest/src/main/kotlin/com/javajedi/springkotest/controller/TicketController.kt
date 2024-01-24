package com.javajedi.springkotest.controller

import com.javajedi.springkotest.messages.Ticket
import org.springframework.jms.core.JmsTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/tickets")
class TicketController(
    private val jmsTemplate: JmsTemplate
) {

    @PostMapping
    fun sendMessage(@RequestBody ticket: Ticket) {
        println(ticket)
        jmsTemplate.convertAndSend("ticket_queue", ticket)
    }

}