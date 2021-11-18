package com.sagrd.travelmanagement.network


import com.sagrd.travelmanagement.model.Viaje
import retrofit2.http.GET

interface TravelApi {

    @GET("Viaje")
    suspend fun getTravels():List<Viaje>
}
