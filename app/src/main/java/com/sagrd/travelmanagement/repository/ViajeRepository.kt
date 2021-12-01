package com.sagrd.travelmanagement.repository

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Update
import com.sagrd.travelmanagement.data.AppDataBase
import com.sagrd.travelmanagement.model.Viaje
import com.sagrd.travelmanagement.network.RetrofitInstance

class ViajeRepository(private val database: AppDataBase) {

    suspend fun Insert(viaje:Viaje){
        database.viajeDao.Insert(viaje)
    }

    suspend fun Update(viaje:Viaje){
        database.viajeDao.Update(viaje)
    }

    fun Find(key:Long):LiveData<Viaje>{
        return  database.viajeDao.Find(key)
    }

    fun Lista(): LiveData<List<Viaje>> {
        return  database.viajeDao.Lista()
    }
/*
    suspend fun GetApi(): List<Viaje>{
        return RetrofitInstance.api.getTravels()
    }*/
}
