package com.sagrd.travelmanagement.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.util.*

@Entity
data class CobroDetalle(
    @PrimaryKey(autoGenerate = true)
    var CobroDetalleId: Long,
    var CobroId: Long,
    var VentaId: Long,
    var Cobrado: Float,
)

/*
data class CobrosVentas(
    @Embedded val cobros: Cobros,
    @Relation(
        parentColumn = "cobroId",
        entityColumn = "ventaId"
    )
    val detalle : List<CobrosDetalle>
)*/
