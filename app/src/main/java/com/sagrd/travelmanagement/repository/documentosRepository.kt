package com.sagrd.travelmanagement.repository

import androidx.lifecycle.LiveData
import com.sagrd.travelmanagement.data.AppDataBase
import com.sagrd.travelmanagement.model.Documentos
import com.sagrd.travelmanagement.model.Gasto
import com.sagrd.travelmanagement.model.Viaje
import com.sagrd.travelmanagement.network.RetrofitInstance
import com.sagrd.travelmanagement.ui.estadoviaje.EstadoViajeFragment

class documentosRepository(private val database: AppDataBase) {

    suspend fun GetApi(): List<Documentos>{
        return RetrofitInstance.api.getEstado()
    }
}