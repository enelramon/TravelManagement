package com.sagrd.travelmanagement.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.sagrd.travelmanagement.model.*

@Dao
interface CobroDao {
    fun insert(cobro: Cobro) {

        //atrapar el id del cobro
        val id = insertarCobro(cobro)

        //asignar el id al detalle
        cobro.detalle.forEach { i -> i.cobroId = id}

        //insertar el detalle
        insertarDetalle(cobro.detalle)
    }

    @Insert
    abstract fun insertarCobro(cobros: Cobro): Long //return type is the key here.

    @Insert
    abstract fun insertarDetalle(detalle: List<CobroDetalle>)

    @Query("SELECT * FROM Cobro WHERE CobroId = :key")
    fun Find(key:Long) : LiveData<Cobro>

    @Transaction
    @Query("SELECT * FROM Cobro ORDER BY CobroId DESC")
    fun loadAll(): LiveData<List<Cobro>>
}