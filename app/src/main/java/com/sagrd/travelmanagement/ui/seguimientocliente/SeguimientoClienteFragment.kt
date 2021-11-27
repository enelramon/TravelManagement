package com.sagrd.travelmanagement.ui.seguimientocliente

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.sagrd.travelmanagement.R
import com.sagrd.travelmanagement.databinding.SeguimientoClienteFragmentBinding
import java.time.Month


class SeguimientoClienteFragment : Fragment() {

    private var _binding: SeguimientoClienteFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = SeguimientoClienteFragmentBinding.inflate(inflater, container, false)

        val lista = resources.getStringArray(R.array.lista)
        val arrayAdapterLista = ArrayAdapter(requireContext(),R.layout.dropdown_item,lista)
        binding.autoCompleteTextView2.setAdapter(arrayAdapterLista)

        val estado = resources.getStringArray(R.array.estado)
        val arrayAdapterEstado = ArrayAdapter(requireContext(),R.layout.dropdown_item,estado)
        binding.autoCompleteTextView.setAdapter(arrayAdapterEstado)

        return binding.root
    }

}