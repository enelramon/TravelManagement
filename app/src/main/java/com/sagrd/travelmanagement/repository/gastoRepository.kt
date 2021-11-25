package com.sagrd.travelmanagement.repository

import androidx.lifecycle.LiveData
import com.sagrd.travelmanagement.data.AppDataBase
import com.sagrd.travelmanagement.model.Gasto

class gastoRepository(private val database: AppDataBase) {

    suspend fun Insert(gasto: Gasto){
        database.gastoDao.Insert(gasto)
    }

    suspend fun Update(gasto: Gasto){
        database.gastoDao.Update(gasto)
    }

    fun Find(key:Long): LiveData<Gasto> {
        return  database.gastoDao.Find(key)
    }

    fun Lista(): LiveData<List<Gasto>> {
        return  database.gastoDao.Lista()
    }
}