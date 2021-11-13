package com.sagrd.travelmanagement.ui.EstadoViaje

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sagrd.travelmanagement.R

class EstadoViajeFragment : Fragment() {

    companion object {
        fun newInstance() = EstadoViajeFragment()
    }

    private lateinit var viewModel: EstadoViajeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.estado_viaje_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EstadoViajeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}