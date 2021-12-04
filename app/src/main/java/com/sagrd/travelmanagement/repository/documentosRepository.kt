package com.sagrd.travelmanagement.repository

import androidx.lifecycle.LiveData
import com.sagrd.travelmanagement.data.AppDataBase
import com.sagrd.travelmanagement.model.Documentos
import com.sagrd.travelmanagement.model.Gasto
import com.sagrd.travelmanagement.model.Viaje
import com.sagrd.travelmanagement.network.RetrofitInstance

class documentosRepository(private val database: AppDataBase) {

    suspend fun GetApiEstado(travelsId : Int): List<Documentos>{
        return RetrofitInstance.api.getEstado(travelsId)
    }

}