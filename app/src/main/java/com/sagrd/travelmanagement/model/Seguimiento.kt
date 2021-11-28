package com.sagrd.travelmanagement.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Seguimiento(
    @PrimaryKey(autoGenerate = true)
    var seguimientoId: Long,
    var Fecha: String,
    var ClienteId: Long,
    var Comentarios: String,
    var Tipo: String,
    var Estado: String,
    var ProximoContacto: String
)