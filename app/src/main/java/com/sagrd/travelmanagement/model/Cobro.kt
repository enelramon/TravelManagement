package com.sagrd.travelmanagement.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.util.*

@Entity
data class Cobro(
    @PrimaryKey(autoGenerate = true)
    var CobroId: Long=0,
    var Fecha: Date,
    var ClienteId: Long,
    var Monto: Float,

    @Relation(
        parentColumn = "cobroId",
        entityColumn = "cobroId"
    )
    var detalle : List<CobroDetalle>
)