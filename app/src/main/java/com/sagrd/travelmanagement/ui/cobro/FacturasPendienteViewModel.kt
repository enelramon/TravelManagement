package com.sagrd.travelmanagement.ui.cobro

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.sagrd.travelmanagement.data.AppDataBase
import com.sagrd.travelmanagement.model.Cobro
import com.sagrd.travelmanagement.model.Venta
import com.sagrd.travelmanagement.repository.CobroRepository
import com.sagrd.travelmanagement.repository.VentaRepository
import kotlinx.coroutines.launch


@SuppressLint("LongLogTag")
class FacturasPendienteViewModel(application: Application): ViewModel(){

    private val _listaVentasApi = MutableLiveData<List<Venta>>()
    val listaVentasApi : LiveData<List<Venta>>
        get() = _listaVentasApi

    private val ventaRepository = VentaRepository(AppDataBase.getInstance(application))
    private val cobroRepository = CobroRepository(AppDataBase.getInstance(application))

    fun Post(cobro: Cobro) = viewModelScope.launch{
        cobroRepository.postCobro(cobro)
    }

    init {
        viewModelScope.launch {
            try{
                _listaVentasApi.value = ventaRepository.Get()
            }
            catch (e: Exception)
            {
                Log.e("FacturasPendienteViewModel", "Fallo al buscar los datos api")
            }

        }
    }

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