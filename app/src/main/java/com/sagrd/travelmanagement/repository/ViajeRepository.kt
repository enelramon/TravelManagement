package com.sagrd.travelmanagement.repository

import android.util.Log
import androidx.lifecycle.LiveData
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

    fun PostApi(viaje: Viaje)
    {
        var _viaje = viaje
        RetrofitInstance.api.postViaje(viaje).enqueue(object : Callback<Viaje> {
            override fun onResponse(call: Call<Viaje>, response: Response<Viaje>) {
                _viaje = response.body()!!
                Log.i("Bueno", Gson().toJson(viaje))
            }

            override fun onFailure(call: Call<Viaje>, t: Throwable) {
                t?.printStackTrace()
            }
        })
    }

}
