package com.sagrd.travelmanagement.ui.estadoviaje

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.sagrd.travelmanagement.R
import com.sagrd.travelmanagement.adapters.ViajeAdapter
import com.sagrd.travelmanagement.databinding.EstadoViajeFragmentBinding
import com.sagrd.travelmanagement.model.Viaje
import java.time.LocalDateTime
import com.sagrd. travelmanagement.utils.*

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

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}