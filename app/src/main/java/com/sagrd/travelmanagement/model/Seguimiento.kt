package com.sagrd.travelmanagement.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Seguimiento(
    @PrimaryKey(autoGenerate = true)
    var seguimientoId: Long,
    var fecha: String,
    var clienteId: Long,
    var comentarios: String,
    var tipo: Long,
    var estado: Long,
    var proximoContacto: String
)