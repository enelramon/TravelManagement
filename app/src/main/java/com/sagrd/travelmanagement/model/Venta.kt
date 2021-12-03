package com.sagrd.travelmanagement.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Venta(
    @PrimaryKey(autoGenerate = true)
    var ventaId: Long,
    var fecha: String,
    var clienteId: Long,
    var monto: Float,
    var balance: Float
)