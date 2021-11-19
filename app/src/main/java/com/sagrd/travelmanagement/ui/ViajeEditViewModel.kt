package com.sagrd.travelmanagement.ui

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Update
import com.sagrd.travelmanagement.data.AppDataBase
import com.sagrd.travelmanagement.databinding.ViajeEditFragmentBinding
import com.sagrd.travelmanagement.model.Viaje
import com.sagrd.travelmanagement.repository.ViajeRepository
import com.sagrd.travelmanagement.utils.getFloat
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class ViajeEditViewModel(application: Application) : ViewModel() {

    private val viajeRepository = ViajeRepository(AppDataBase.getInstance(application))
    private lateinit var binding : ViajeEditFragmentBinding

   /* val viaje: LiveData<Viaje>
        get() = viajeRepository.Find(1)
*/
    // The internal MutableLiveData String that stores the most recent response
//    private val _response = MutableLiveData<String>()
//
//    val response: LiveData<String>
//        get() = _response
//
//    private var _listaSolares = MutableLiveData<List<Solares>>()
//    val listaSolares: LiveData<List<Solares>>
//        get() = _listaSolares
//
//    init {
//        getSolares()
//    }
//
    fun Insert(viaje: Viaje) = viewModelScope.launch {
        viajeRepository.Insert(viaje)
    }

    fun Update(viaje: Viaje) = viewModelScope.launch {
        viajeRepository.Update(viaje)
    }

//
//
//    fun getSolares() {
//        viewModelScope.launch {
//            try {
//                _listaSolares.value = SolaresApi.RetrofitApi.getSolares()
//                _response.value = "Solares encontrados: "
//            } catch (e: Exception) {
//                _response.value = "fallo al buscar solares${e.message}"
//            }
//        }
//    }




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















