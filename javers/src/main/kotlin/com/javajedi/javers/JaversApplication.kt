package com.javajedi.javers

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class JaversApplication {

    @Bean
    fun commandLineRunner(ticketService: TicketService): CommandLineRunner {
        return CommandLineRunner { _ ->
            ticketService.findAll().ifEmpty {
                listOf(
                    Triple("Eminem concert", 399.9, 120),
//                    Triple("Imagine Dragons", 299.9, 10),
                )
                    .forEach { (name, price, quantity) ->
                        ticketService.saveTicket(name, price, quantity)
                    }
            }
        }
    }

}

fun main(args: Array<String>) {
    runApplication<JaversApplication>(*args)
}
