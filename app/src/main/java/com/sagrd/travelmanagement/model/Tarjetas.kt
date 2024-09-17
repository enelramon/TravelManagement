package com.sagrd.travelmanagement.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tarjetas(
    // tarjetaId":1,"descripcion":"TC ENEL","balance":0.0
    @PrimaryKey(autoGenerate = true)
    val tarjetaId : Long,
    var descripcion   : String,
    var balance   : Float

)



