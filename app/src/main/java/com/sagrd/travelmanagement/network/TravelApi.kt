package com.sagrd.travelmanagement.network


import com.sagrd.travelmanagement.model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface TravelApi {

    @GET("Viajes")
    suspend fun getTravels():List<Viaje>

    @POST("Viajes")
    fun postViaje(@Body viaje: Viaje) : Call<Viaje>

    @GET("Ventas/{id}")
    suspend fun getVentas(@Path("id")id :Int):List<Venta>

    @POST("Cobros")
    fun postCobro(@Body cobro: Cobro) : Call<Cobro>

    @GET("Gastos")
    suspend fun getGastos():List<Gasto>

    @GET("Clientes")
    suspend fun getClientes():List<Clientes>

    @GET("Tarjetas")
    suspend fun getTarjetas():List<Tarjetas>

    @POST("Gastos")
    fun postGasto(@Body gasto: Gasto?) : Call<Gasto>

    @GET("EstadoTarjetas/{id}")
    suspend fun getEstado(@Path("id")id :Int):List<Documentos>

    @POST("Seguimientos")
    fun postSeguimiento(@Body seguimiento: Seguimiento?) : Call<Seguimiento>
}
