package com.sagrd.travelmanagement.repository

import android.util.Log
import com.google.gson.Gson
import com.sagrd.travelmanagement.data.AppDataBase
import com.sagrd.travelmanagement.model.Cobro
import com.sagrd.travelmanagement.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CobroRepository(private val database: AppDataBase) {
    fun postCobro(cobro: Cobro)
    {
        var _cobro = cobro
        RetrofitInstance.api.postCobro(cobro).enqueue(object : Callback<Cobro> {
            override fun onResponse(call: Call<Cobro>, response: Response<Cobro>) {
                _cobro = response.body()!!
                Log.i("Bueno", Gson().toJson(cobro))
            }

            override fun onFailure(call: Call<Cobro>, t: Throwable) {
                t?.printStackTrace()
            }
        })
    }
}