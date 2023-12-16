package com.javajedi.springkotest.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "city")
data class City(

    @Id
    @Column(name = "id")
    val id: Int,

    @Column(name = "name")
    val name: String

)
