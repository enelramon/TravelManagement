package com.sagrd.travelmanagement.ui

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.sagrd.travelmanagement.data.AppDataBase
import com.sagrd.travelmanagement.model.Viaje
import com.sagrd.travelmanagement.repository.ViajeRepository
import kotlinx.coroutines.launch

class ViajesListViewModel(application: Application) : ViewModel() {
    private val viajeRepository = ViajeRepository(AppDataBase.getInstance(application))
    val list = viajeRepository.Lista()

    //Factory for constructing DevByteViewModel with parameter
    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ViajesListViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ViajesListViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}
