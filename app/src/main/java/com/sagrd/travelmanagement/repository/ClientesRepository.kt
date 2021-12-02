package com.sagrd.travelmanagement.repository

import com.sagrd.travelmanagement.data.AppDataBase
import com.sagrd.travelmanagement.model.Cliente
import com.sagrd.travelmanagement.network.RetrofitInstance

class ClientesRepository(private val database: AppDataBase) {
    suspend fun GetClientes(): List<Cliente>{
        return RetrofitInstance.api.getClientes()
    }

}