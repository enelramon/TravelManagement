package com.sagrd.travelmanagement.ui.estadoviaje

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Query
import com.sagrd.travelmanagement.data.AppDataBase
import com.sagrd.travelmanagement.model.Gasto
import com.sagrd.travelmanagement.model.Viaje
import com.sagrd.travelmanagement.repository.*

class EstadoViajeViewModel(application: Application): ViewModel() {

    private val viajeRepository = ViajeRepository(AppDataBase.getInstance(application))
    private val gastoRepository = gastoRepository(AppDataBase.getInstance(application))
    private val documentoRepository = documentosRepository(AppDataBase.getInstance(application))
    lateinit var item : Viaje
    lateinit var item2 : Gasto
    val list = viajeRepository.Lista()
    val gastoLista = gastoRepository.Lista()



    class Factory(val app : Application) : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(EstadoViajeViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return EstadoViajeViewModel(app) as T
            }
            throw IllegalAccessException("Unable to construct viewmodel")
        }
    }
}