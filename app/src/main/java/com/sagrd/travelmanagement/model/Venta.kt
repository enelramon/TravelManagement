package com.sagrd.travelmanagement.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Venta(
    @PrimaryKey(autoGenerate = true)
    var VentaId: Long,
    var Fecha: Date,
    var ClienteId: Long,
    var Monto: Float,
    var Balance: Float
)