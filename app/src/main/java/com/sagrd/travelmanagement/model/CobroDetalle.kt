package com.sagrd.travelmanagement.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class CobroDetalle(
    @PrimaryKey(autoGenerate = true)
    var CobroDetalleId: Long,
    var CobroId: Long,
    var VentaId: Long,
    var Cobrado: Float,
)