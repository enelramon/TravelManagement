package com.sagrd.travelmanagement.ui.GastoViaje

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GastoViajeViewModel(application: Application) : ViewModel() {

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