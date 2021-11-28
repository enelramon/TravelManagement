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
import com.sagrd.travelmanagement.model.Seguimiento


class SeguimientoClienteFragment : Fragment() {

    private var _binding: SeguimientoClienteFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: SeguimientoClienteViewModel

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=
            ViewModelProvider(this, SeguimientoClienteViewModel.Factory(requireActivity().application))
                .get(SeguimientoClienteViewModel::class.java)

        binding.guardarButton.setOnClickListener{
            viewModel.Post(LlenaClase())
        }
    }

    fun LlenaClase() : Seguimiento {
        return Seguimiento(
            0,
            "2021-11-25T01:48:33",
            1,
            binding.ComentarioTextInputEditText.text.toString(),
            binding.autoCompleteTextView2.text.toString(),
//            binding.autoCompleteTextView2.text.toString(),
            binding.autoCompleteTextView.text.toString(),
            "2021-11-29T01:48:33"
        )
    }
}