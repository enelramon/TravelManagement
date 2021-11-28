package com.sagrd.travelmanagement.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Delete
import androidx.room.Update
import com.google.gson.Gson
import com.sagrd.travelmanagement.data.AppDataBase
import com.sagrd.travelmanagement.model.Viaje
import com.sagrd.travelmanagement.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

    suspend fun GetApi(): List<Viaje>{
        return RetrofitInstance.api.getTravels()
    }
//    fun PostApi(viaje: Viaje)
//    {
//
//    }
//
}
