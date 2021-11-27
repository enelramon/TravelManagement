package com.sagrd.travelmanagement.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Cobro(
    @PrimaryKey(autoGenerate = true)
    var CobroId: Long,
    var Fecha: Date,
    var ClienteId: Long,
    var Monto: Float,
)