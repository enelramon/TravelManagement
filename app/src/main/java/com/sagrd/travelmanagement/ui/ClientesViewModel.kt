package com.sagrd.travelmanagement.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.sagrd.travelmanagement.data.AppDataBase
import com.sagrd.travelmanagement.repository.ClientesRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class ClientesViewModel(application: Application):ViewModel() {
    private val _listaClientesApi = MutableLiveData<List<Clientes>>()
    val listaClientesApi:LiveData<List<Clientes>>
        get() = _listaClientesApi

    private val clientesRepository = ClientesRepository(AppDataBase.getInstance(application))
    init {
        viewModelScope.launch {
            try {
                _listaClientesApi.value = clientesRepository.GetClientes()

            }catch (e:Exception){
                Log.e("ClientesViewModel", "Fallo al buscar los datos api")
            }
        }
    }

    class Factory (val app: Application): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ClientesViewModel::class.java)){
                @Suppress("UNCHECKER_CAST")
                return ClientesViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }

    
}