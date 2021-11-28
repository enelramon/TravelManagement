package com.sagrd.travelmanagement.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Gasto(
    @PrimaryKey(autoGenerate = true)
    var gastoId: Long,
    var fecha: String,
    var tarjetaId: Long,
    var concepto: String,
    var monto: Float,

)