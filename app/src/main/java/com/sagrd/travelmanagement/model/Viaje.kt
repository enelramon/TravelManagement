package com.sagrd.travelmanagement.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class Viaje(
    @PrimaryKey(autoGenerate = true)
    var ViajeId:Long,
    var Fecha: LocalDateTime,
    var Concepto: String,
    var Monto: Float
)
