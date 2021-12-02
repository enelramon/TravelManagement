package com.sagrd.travelmanagement.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.sagrd.travelmanagement.adapters.ClientesAdapter
import com.sagrd.travelmanagement.adapters.documentosAdapter
import com.sagrd.travelmanagement.databinding.ClientesFragmentBinding
import com.sagrd.travelmanagement.databinding.EstadoViajeFragmentBinding

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

        _binding = ClientesFragmentBinding.inflate(layoutInflater)

        viewModel =
            ViewModelProvider(this, ClientesViewModel.Factory(requireActivity().application))
                .get(ClientesViewModel::class.java)


        viewModel.listaClientesApi.observe(viewLifecycleOwner, Observer{
            val adapter = ClientesAdapter()
            adapter.submitList(it)
            binding.ClientesRecyclerView.adapter = adapter
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}