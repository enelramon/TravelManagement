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
import com.sagrd.travelmanagement.R
import com.sagrd.travelmanagement.adapters.ViajeAdapter
import com.sagrd.travelmanagement.adapters.documentosAdapter
import com.sagrd.travelmanagement.adapters.gastoAdapter
import com.sagrd.travelmanagement.databinding.EstadoViajeFragmentBinding
import com.sagrd.travelmanagement.model.Documentos

class EstadoViajeFragment : Fragment() {

    companion object {
        fun newInstance() = EstadoViajeFragment()
    }

    private lateinit var viewModel: EstadoViajeViewModel

    private var _binding : EstadoViajeFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = EstadoViajeFragmentBinding.inflate(inflater, container, false)
        viewModel =
            ViewModelProvider(this, EstadoViajeViewModel.Factory(requireActivity().application))
                .get(EstadoViajeViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.estadoViajeRecyclerView.adapter = ViajeAdapter()
        val adapter = binding.estadoViajeRecyclerView.adapter as ViajeAdapter

        viewModel.list.observe(viewLifecycleOwner, Observer{
            adapter.submitList(it)
        })

        binding.gastoButton.setOnClickListener{
            findNavController().navigate(R.id.gastoViajeFragment)
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