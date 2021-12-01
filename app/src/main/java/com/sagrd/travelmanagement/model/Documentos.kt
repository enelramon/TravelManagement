package com.sagrd.travelmanagement.model

import androidx.room.Entity
import java.util.Date

@Entity
data class Documentos(
    var Id: Long,
    var Fecha: Date,
    var Tipo: String,
    var Concepto: String,
    var Monto: Float,
    var Balance: Float
)