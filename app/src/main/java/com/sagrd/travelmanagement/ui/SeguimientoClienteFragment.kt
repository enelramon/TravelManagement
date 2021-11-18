package com.sagrd.travelmanagement.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.sagrd.travelmanagement.R
import com.sagrd.travelmanagement.databinding.SeguimientoClienteFragmentBinding


class SeguimientoClienteFragment : Fragment() {

    private var _binding: SeguimientoClienteFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = SeguimientoClienteFragmentBinding.inflate(inflater, container, false)

        val lista = resources.getStringArray(R.array.lista)
        val arrayAdapterLista = ArrayAdapter(requireContext(),R.layout.dropdown_item,lista)
        binding.autoCompleteTextView.setAdapter(arrayAdapterLista)

        val estados = resources.getStringArray(R.array.estado)
        val arrayAdapterEstado = ArrayAdapter(requireContext(),R.layout.dropdown_item,estados)
        binding.autoCompleteTextView.setAdapter(arrayAdapterEstado)

        return binding.root
    }
}