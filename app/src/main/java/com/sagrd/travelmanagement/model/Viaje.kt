package com.sagrd.travelmanagement.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Viaje(
    @PrimaryKey(autoGenerate = true)
    var ViajeId: Long,
    var Fecha: Date,
    //falta TarjetaId
    var Concepto: String,
    //millas, tasadolar
    var Monto: Float //= precioxMillas * Millas * TasaDolar
)
