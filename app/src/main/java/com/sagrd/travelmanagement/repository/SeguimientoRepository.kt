package com.sagrd.travelmanagement.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.google.gson.Gson
import com.sagrd.travelmanagement.data.AppDataBase
import com.sagrd.travelmanagement.model.Seguimiento
import com.sagrd.travelmanagement.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class SeguimientoRepository(private val database: AppDataBase) {

    suspend fun Insert(seguimiento: Seguimiento){
        database.seguimientoDao.Insert(seguimiento)
    }

    suspend fun Update(seguimiento: Seguimiento){
        database.seguimientoDao.Update(seguimiento)
    }

    fun Find(key:Long): LiveData<Seguimiento> {
        return database.seguimientoDao.Find(key)
    }

    fun Lista(): LiveData<List<Seguimiento>> {
        return database.seguimientoDao.Lista()
    }

    fun PostApi(seguimiento: Seguimiento)
    {
        var _seguimiento = seguimiento
        RetrofitInstance.api.postSeguimiento(seguimiento).enqueue(object : Callback<Seguimiento> {
            override fun onResponse(call: Call<Seguimiento>, response: Response<Seguimiento>) {
                _seguimiento = response.body()!!
                Log.i("Bueno", Gson().toJson(seguimiento))
            }

            override fun onFailure(call: Call<Seguimiento>, t: Throwable) {
                t?.printStackTrace()
            }
        })
    }
}