package com.sagrd.travelmanagement.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.google.gson.Gson
import com.sagrd.travelmanagement.data.AppDataBase
import com.sagrd.travelmanagement.model.Gasto
import com.sagrd.travelmanagement.model.Viaje
import com.sagrd.travelmanagement.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

    suspend fun GetApi(): List<Gasto>{
        return RetrofitInstance.api.getGastos()
    }

    fun PostApi(gasto: Gasto)
    {
        var _gasto = gasto
        RetrofitInstance.api.postGasto(gasto).enqueue(object : Callback<Gasto> {
            override fun onResponse(call: Call<Gasto>, response: Response<Gasto>) {
                _gasto = response.body()!!
                Log.i("Bueno", Gson().toJson(gasto))
            }

            override fun onFailure(call: Call<Gasto>, t: Throwable) {
                t?.printStackTrace()
            }
        })
    }
}