package com.sagrd.travelmanagement.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import java.time.LocalDateTime
import com.sagrd.travelmanagement.R
import com.sagrd.travelmanagement.adapters.ViajeAdapter
import com.sagrd.travelmanagement.databinding.FacturasPendienteFragmentBinding
import com.sagrd. travelmanagement.utils.*

class FacturasPendienteFragment : Fragment() {

    companion object {
        fun newInstance() = FacturasPendienteFragment()
    }

    private lateinit var viewModel: FacturasPendienteViewModel
    private var _binding : FacturasPendienteFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FacturasPendienteFragmentBinding.inflate(inflater, container, false)

        viewModel =
            ViewModelProvider(this, FacturasPendienteViewModel.Factory(requireActivity().application))
                .get(FacturasPendienteViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.facturasPendienteRecyclerView.adapter = ViajeAdapter()
        val adapter = binding.facturasPendienteRecyclerView.adapter as ViajeAdapter

        viewModel.list.observe(viewLifecycleOwner, Observer{
            adapter.submitList(it)
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}