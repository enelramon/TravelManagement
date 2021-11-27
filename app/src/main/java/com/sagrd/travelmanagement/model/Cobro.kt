package com.sagrd.travelmanagement.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Cobro(
    @PrimaryKey(autoGenerate = true)
    var GastoId: Long,
    var Fecha: Date,
    //falta TarjetaId
    var Concepto: String,
    var Monto: Float,
)