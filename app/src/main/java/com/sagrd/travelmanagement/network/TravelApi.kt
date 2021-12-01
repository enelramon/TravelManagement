package com.sagrd.travelmanagement.network


import com.sagrd.travelmanagement.model.Cobro
import com.sagrd.travelmanagement.model.Venta
import com.sagrd.travelmanagement.model.Viaje
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import com.sagrd.travelmanagement.model.Documentos
import com.sagrd.travelmanagement.model.Gasto
import com.sagrd.travelmanagement.model.Viaje
import retrofit2.http.*
import retrofit2.Call

interface TravelApi {

    @GET("Viajes")
    suspend fun getTravels():List<Viaje>

    @GET("Ventas")
    suspend fun getVentas():List<Venta>

    @POST("Viajes")
    fun postViaje(@Body viaje: Viaje) : Call<Viaje>

    @POST("Cobros")
    fun postCobro(@Body cobro: Cobro) : Call<Cobro>
    @POST("Viajes")
    fun postViaje(@Body viaje: Viaje?) : Call<Viaje>

    @GET("Gastos")
    suspend fun getGastos():List<Gasto>

    @POST("Gastos")
    fun postGasto(@Body gasto: Gasto?) : Call<Gasto>

    @GET("EstadoTarjetas/1")
    suspend fun getEstado():List<Documentos>
}
