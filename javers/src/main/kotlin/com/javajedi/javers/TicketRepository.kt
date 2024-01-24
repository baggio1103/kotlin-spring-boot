package com.javajedi.javers

import org.javers.spring.annotation.JaversSpringDataAuditable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

@JaversSpringDataAuditable
interface TicketRepository : JpaRepository<Ticket, Int> {

    @Query("SELECT nextval('ticket_SEQ')", nativeQuery = true)
    fun selectNextIdVal(): Int

}