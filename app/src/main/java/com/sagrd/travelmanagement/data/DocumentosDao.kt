package com.sagrd.travelmanagement.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.sagrd.travelmanagement.model.Gasto
import com.sagrd.travelmanagement.model.Viaje
import com.sagrd.travelmanagement.model.Documentos

@Dao
interface DocumentosDao {
//    @Query("Select :gasto.GastoId, :gasto.Fecha, 'gasto' as Tipo, :gasto.Concepto, :gasto.Monto , 0 as Balance FROM Gasto UNION ALL Select :viaje.ViajeId, :viaje.Fecha, 'viaje' as Tipo, :viaje.Concepto, :viaje.Monto , (:gasto.Monto + :Viaje.Monto) as Balance FROM Viajes")
//    fun Mix(viaje: Viaje, gasto: Gasto): LiveData<List<Documentos>>
}