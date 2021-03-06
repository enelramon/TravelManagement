package com.sagrd.travelmanagement.ui.viajes

import android.app.Application
import androidx.lifecycle.*
import com.sagrd.travelmanagement.data.AppDataBase
import com.sagrd.travelmanagement.databinding.ViajeEditFragmentBinding
import com.sagrd.travelmanagement.model.Viaje
import com.sagrd.travelmanagement.repository.ViajeRepository
import kotlinx.coroutines.launch

class ViajeEditViewModel(application: Application) : ViewModel() {

    private val viajeRepository = ViajeRepository(AppDataBase.getInstance(application))
    private lateinit var binding : ViajeEditFragmentBinding

    fun Insert(viaje: Viaje) = viewModelScope.launch {
        viajeRepository.Insert(viaje)
    }

    fun Post(viaje: Viaje) = viewModelScope.launch {
        viajeRepository.PostApi(viaje)
    }

    //Factory for constructing DevByteViewModel with parameter
    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ViajeEditViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ViajeEditViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}















