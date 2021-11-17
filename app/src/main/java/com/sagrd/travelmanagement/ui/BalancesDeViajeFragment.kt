package com.sagrd.travelmanagement.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sagrd.travelmanagement.R
/*
        para llenar mi lista nesesito los datos siguientes (nombre del clinte)
        el monto de las milla y las milla que el clinete recorrigio e su vuelo
* */


class BalancesDeViajeFragment : Fragment() {

    companion object {
        fun newInstance() = BalancesDeViajeFragment()
    }

    private lateinit var viewModel: BalancesDeViajeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.balances_de_viaje_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BalancesDeViajeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}