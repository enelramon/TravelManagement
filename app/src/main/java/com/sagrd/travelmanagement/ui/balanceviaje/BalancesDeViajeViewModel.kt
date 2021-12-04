package com.sagrd.travelmanagement.ui.balanceviaje

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.sagrd.travelmanagement.data.AppDataBase
import com.sagrd.travelmanagement.model.Clientes
import com.sagrd.travelmanagement.model.Documentos
import com.sagrd.travelmanagement.model.Tarjetas
import com.sagrd.travelmanagement.network.RetrofitInstance
import com.sagrd.travelmanagement.repository.documentosRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class BalancesDeViajeViewModel(app: Application) : ViewModel() {
    // TODO: Implement the ViewModel
    private var _lista = MutableLiveData<List<Tarjetas>>()

    val lista : LiveData<List<Tarjetas>>
        get() = _lista

    init {
        try {
            viewModelScope.launch {
                _lista.value = RetrofitInstance.api.getTarjetas()
            }
        }catch (E : Exception){
            Log.e("ERROR","Fallo al obtener clientes del api")
        }
    }

    private val _listaDocumentoApi = MutableLiveData<List<Documentos>>()
    private val documentoRepository = documentosRepository(AppDataBase.getInstance(app))

    fun octenertarjeta(tarjertaId :Int): MutableLiveData<List<Documentos>>{

        viewModelScope.launch {
            try{
                _listaDocumentoApi.value = documentoRepository.GetApiEstado(tarjertaId).subList(0,0)
            }
            catch (e: Exception) {
                Log.e("EstadoViajeViewModel", "Fallo al buscar los datos api")
            }
        }
        return _listaDocumentoApi
    }


    class Factory (val app: Application): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(BalancesDeViajeViewModel::class.java)){
                @Suppress("UNCHECKER_CAST")
                return BalancesDeViajeViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}