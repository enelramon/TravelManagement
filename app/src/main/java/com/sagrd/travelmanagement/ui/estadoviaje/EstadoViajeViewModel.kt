package com.sagrd.travelmanagement.ui.estadoviaje

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sagrd.travelmanagement.data.AppDataBase
import com.sagrd.travelmanagement.repository.ViajeRepository

class EstadoViajeViewModel(application: Application): ViewModel() {

    private val viajeRepository = ViajeRepository(AppDataBase.getInstance(application))
    val list = viajeRepository.Lista()

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