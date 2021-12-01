package com.sagrd.travelmanagement.ui.gastoviaje

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.sagrd.travelmanagement.data.AppDataBase
import com.sagrd.travelmanagement.databinding.GastoViajeFragmentBinding
import com.sagrd.travelmanagement.databinding.ViajeEditFragmentBinding
import com.sagrd.travelmanagement.model.Gasto
import com.sagrd.travelmanagement.repository.gastoRepository
import kotlinx.coroutines.launch

class GastoViajeViewModel(application: Application) : ViewModel() {

    private val gastoRepository = gastoRepository(AppDataBase.getInstance(application))
    private lateinit var binding : GastoViajeFragmentBinding


    fun Insert(gasto: Gasto) = viewModelScope.launch {
        gastoRepository.Insert(gasto)
    }

    fun Update(gasto: Gasto) = viewModelScope.launch {
        gastoRepository.Update(gasto)
    }


    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(GastoViajeViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return GastoViajeViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}