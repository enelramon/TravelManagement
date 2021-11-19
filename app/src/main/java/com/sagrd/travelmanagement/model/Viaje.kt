package com.sagrd.travelmanagement.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Viaje(
    @PrimaryKey(autoGenerate = true)
    var ViajeId:Long,
    var Fecha: Date,
    var Concepto: String,
    var Monto: Float
)
