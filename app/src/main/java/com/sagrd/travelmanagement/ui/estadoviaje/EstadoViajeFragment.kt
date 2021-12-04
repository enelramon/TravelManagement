package com.sagrd.travelmanagement.ui.estadoviaje

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.sagrd.travelmanagement.R
import com.sagrd.travelmanagement.adapters.ViajeAdapter
import com.sagrd.travelmanagement.adapters.documentosAdapter
import com.sagrd.travelmanagement.adapters.gastoAdapter
import com.sagrd.travelmanagement.databinding.EstadoViajeFragmentBinding
import com.sagrd.travelmanagement.model.Documentos
import com.sagrd.travelmanagement.model.Gasto

class EstadoViajeFragment : Fragment() {

    private var _binding : EstadoViajeFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = EstadoViajeFragment()
    }

    private lateinit var viewModel: EstadoViajeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = EstadoViajeFragmentBinding.inflate(layoutInflater)
        viewModel =
            ViewModelProvider(this, EstadoViajeViewModel.Factory(requireActivity().application))
                .get(EstadoViajeViewModel::class.java)

//        viewModel.listaDocumentoApi.observe(viewLifecycleOwner, Observer{
//            val adapter = documentosAdapter()
//            adapter.submitList(it)
//            binding.estadoViajeRecyclerView.adapter = adapter
//        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //ahora recibiras la variable tarjetaId
        val int =arguments?.getLong("tarjetaId")!!.toInt()

        viewModel.obtenertarjeta(int).observe(viewLifecycleOwner, Observer{
            val adapter = documentosAdapter()
            adapter.submitList(it)
            binding.estadoViajeRecyclerView.adapter = adapter
        })

        binding.gastoButton.setOnClickListener{
            findNavController().navigate(R.id.action_estadoViajeFragment_to_gastoViajeFragment)
        }
        binding.viajeButton.setOnClickListener{
            findNavController().navigate(R.id.viajeEditFragment)
        }

        var contador = 0
        binding.fabEstadoViajes.setOnClickListener{
            if(contador.mod(2)!=0)
            {
                binding.gastoButton.isVisible = false
                binding.viajeButton.isVisible = false
            }
            else
            {
                binding.gastoButton.isVisible = true
                binding.viajeButton.isVisible = true
            }
            contador++
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}