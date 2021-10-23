package com.sagrd.travelmanagement.repository

import androidx.lifecycle.LiveData
import com.sagrd.travelmanagement.data.AppDataBase
import com.sagrd.travelmanagement.model.Viaje

class ViajeRepository(private val database: AppDataBase) {
    suspend fun Insert(viaje:Viaje)
    {
        database.viajeDao.Insert(viaje)
    }

      fun Find(key:Long):LiveData<Viaje>{
         return  database.viajeDao.Find(key)
     }

      fun Lista(): LiveData<List<Viaje>> {
        return  database.viajeDao.Lista()
    }
}
