package com.sagrd.travelmanagement.network


import com.sagrd.travelmanagement.model.Viaje
import retrofit2.http.*
import retrofit2.Call

interface TravelApi {

    @GET("Viajes")
    suspend fun getTravels():List<Viaje>

    @POST("Viajes")
    fun postViaje(@Body viaje: Viaje) : Call<Viaje>
}
