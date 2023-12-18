package com.javajedi.javers

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "ticket")
data class Ticket(

    @Id
    @GeneratedValue
    val id: Int,

    var name: String,

    var price: Double,

    var quantity: Int

)
