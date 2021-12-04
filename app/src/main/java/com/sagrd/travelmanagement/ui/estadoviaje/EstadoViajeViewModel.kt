package com.sagrd.travelmanagement.ui.estadoviaje

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import androidx.room.Query
import com.sagrd.travelmanagement.data.AppDataBase
import com.sagrd.travelmanagement.model.Documentos
import com.sagrd.travelmanagement.model.Gasto
import com.sagrd.travelmanagement.model.Viaje
import com.sagrd.travelmanagement.network.RetrofitInstance
import com.sagrd.travelmanagement.repository.*
import kotlinx.coroutines.launch

class EstadoViajeViewModel(application: Application): ViewModel() {

    private val _listaDocumentoApi = MutableLiveData<List<Documentos>>()
    val listaDocumentoApi : LiveData<List<Documentos>>
        get() = _listaDocumentoApi


    private val documentoRepository = documentosRepository(AppDataBase.getInstance(application))


    init {
        viewModelScope.launch {
            try{
                _listaDocumentoApi.value = documentoRepository.GetApi()
            }
            catch (e: Exception)
            {
                Log.e("EstadoViajeViewModel", "Fallo al buscar los datos api")
            }
        }
    }

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