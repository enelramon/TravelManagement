package com.sagrd.travelmanagement.ui.seguimientocliente

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.sagrd.travelmanagement.data.AppDataBase
import com.sagrd.travelmanagement.model.Seguimiento
import com.sagrd.travelmanagement.repository.*
import kotlinx.coroutines.launch

class SeguimientoClienteViewModel(application: Application) : ViewModel() {
    // TODO: Implement the ViewModel

    class Factory(val app : Application) : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(SeguimientoClienteViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return SeguimientoClienteViewModel(app) as T
            }
            throw IllegalAccessException("Unable to construct viewmodel")
        }
    }

    private val seguimientoRepository = SeguimientoRepository(AppDataBase.getInstance(application))

    fun Post(seguimiento: Seguimiento) = viewModelScope.launch {
        seguimientoRepository.PostApi(seguimiento)
    }


}