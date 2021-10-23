package com.sagrd.travelmanagement.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

/**
 * A public interface that exposes the [getProperties] method
 */
interface SolaresApiService {
    @GET("realestate")
    suspend fun getSolares():  List<Solares>

    @POST("/api/Banco")
    suspend fun createEmployee(@Body banco: Banco):Banco
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object SolaresApi{
    val RetrofitApi: SolaresApiService by lazy {
        retrofit.create(SolaresApiService::class.java)
    }
}

data class Banco(
    val IdBanco:Int,
    val Nombre:String)

data class Solares(
    val id: String, val img_src: String,
    val type: String,
    val price: Double
)