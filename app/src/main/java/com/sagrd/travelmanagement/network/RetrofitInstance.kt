package com.sagrd.travelmanagement.network

import TravelApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api : TravelApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://travelmanagementapi.somee.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TravelApi::class.java)
    }

}