package com.sagrd.travelmanagement.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.*

@Entity
data class Viaje(
    @PrimaryKey(autoGenerate = true)
    var ViajeId:Long,
    var Millas: Float,
    var Observaciones: String
)
