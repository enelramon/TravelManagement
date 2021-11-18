package com.sagrd.travelmanagement.ui.estadoviaje

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.sagrd.travelmanagement.R
import com.sagrd.travelmanagement.databinding.EstadoViajeFragmentBinding

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =
            ViewModelProvider(this, EstadoViajeViewModel.Factory(requireActivity().application))
                .get(EstadoViajeViewModel::class.java)

        binding.gastoButton.setOnClickListener{
            findNavController().navigate(R.id.gastoViajeFragment)
        }

        binding.viajeButton.setOnClickListener{
            findNavController().navigate(R.id.viajeEditFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}