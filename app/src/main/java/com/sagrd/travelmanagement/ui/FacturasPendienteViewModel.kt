package com.sagrd.travelmanagement.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sagrd.travelmanagement.data.AppDataBase
import com.sagrd.travelmanagement.repository.ViajeRepository


class FacturasPendienteViewModel(application: Application): ViewModel(){
    // TODO: Implement the ViewModel
    private val viajeRepository = ViajeRepository(AppDataBase.getInstance(application))
    val list = viajeRepository.Lista()

    class Factory(val app : Application) : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(FacturasPendienteViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return FacturasPendienteViewModel(app) as T
            }
            throw IllegalAccessException("Unable to construct viewmodel")
        }
    }
}