package com.sagrd.travelmanagement.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Viaje(
    @PrimaryKey(autoGenerate = true)
    val ViajeId: Long,
    val Fecha: Date,
    //val tarjetaId: Long,
    val Concepto: String,
    //val millas: Float,
    //val tasaDolar: Float,
    val Monto: Float //= precioxMillas * Millas * TasaDolar
)
