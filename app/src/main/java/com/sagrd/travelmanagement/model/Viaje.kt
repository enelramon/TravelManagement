package com.sagrd.travelmanagement.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Viaje(
    @PrimaryKey(autoGenerate = true)
    val ViajeId: Long,
    //var Fecha: Date,
    val TarjetaId: Long,
    val Concepto: String,
    val Millas: Float,
    val TasaDolar: Float,
    val Monto: Float //= precioxMillas * Millas * TasaDolar
)
