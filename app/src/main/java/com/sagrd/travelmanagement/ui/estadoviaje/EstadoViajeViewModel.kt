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
    private val documentoRepository = documentosRepository(AppDataBase.getInstance(application))

    fun obtenertarjeta(tarjertaId :Int): LiveData<List<Documentos>>{

         viewModelScope.launch {
            try{
                _listaDocumentoApi.value = documentoRepository.GetApiEstado(tarjertaId)
            }
            catch (e: Exception) {
                Log.e("EstadoViajeViewModel", "Fallo al buscar los datos api")
            }
        }
        return _listaDocumentoApi
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