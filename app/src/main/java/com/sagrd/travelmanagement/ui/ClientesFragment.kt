package com.sagrd.travelmanagement.ui

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
import com.sagrd.travelmanagement.adapters.clientesAdapter
import com.sagrd.travelmanagement.databinding.ClientesFragmentBinding
import com.sagrd.travelmanagement.databinding.FacturasPendienteFragmentBinding
import com.sagrd.travelmanagement.databinding.ViajesListFragmentBinding

class ClientesFragment : Fragment() {

    companion object {
        fun newInstance() = ClientesFragment()
    }

    private lateinit var viewModel: ClientesViewModel
    private var _binding : ClientesFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = ClientesFragmentBinding.inflate(inflater, container, false)

        viewModel =
            ViewModelProvider(this, ClientesViewModel.Factory(requireActivity().application))
                .get(ClientesViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ClientesRecyclerView.adapter = clientesAdapter()
        val adapter = binding.ClientesRecyclerView.adapter as clientesAdapter

        viewModel.listaClientesApi.observe(viewLifecycleOwner, Observer{
            adapter.submitList(it)
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null


    }
}