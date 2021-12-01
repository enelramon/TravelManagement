package com.sagrd.travelmanagement.model

import androidx.room.Entity
import java.util.Date

@Entity
data class Documentos(
    var fecha: String,
    var tipo: String,
    var concepto: String,
    var monto: Float,
    var balance: Float
)