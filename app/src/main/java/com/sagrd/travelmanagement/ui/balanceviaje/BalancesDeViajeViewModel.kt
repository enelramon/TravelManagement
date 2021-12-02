package com.sagrd.travelmanagement.ui.balanceviaje

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.sagrd.travelmanagement.model.Cliente
import com.sagrd.travelmanagement.network.RetrofitInstance
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class BalancesDeViajeViewModel(app: Application) : ViewModel() {
    // TODO: Implement the ViewModel
    private var _lista = MutableLiveData<List<Cliente>>()

    val lista : LiveData<List<Cliente>>
        get() = _lista

    init {
        try {
            viewModelScope.launch {
                _lista.value = RetrofitInstance.api.getClientes()
            }
        }catch (E : Exception){
            Log.e("ERROR","Fallo al obtener clientes del api")
        }
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