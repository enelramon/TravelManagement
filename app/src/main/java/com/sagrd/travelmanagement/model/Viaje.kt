package com.sagrd.travelmanagement.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Viaje(
    @PrimaryKey(autoGenerate = true)
    val travelId: Long,
    val fecha: String,
    val tarjetaId: Long,
    val concepto: String,
    val millas: Float,
    val tasaDolar: Float,
    val monto: Float //= precioxMillas * Millas * TasaDolar
)
