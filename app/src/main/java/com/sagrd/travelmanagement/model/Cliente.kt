package com.sagrd.travelmanagement.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Clientes(
    @PrimaryKey(autoGenerate = true)
    val clienteId :Long,
    var nombres: String,
    var balance :Double
)
