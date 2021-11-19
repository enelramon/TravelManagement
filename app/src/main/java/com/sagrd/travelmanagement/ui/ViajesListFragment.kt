package com.sagrd.travelmanagement.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.sagrd.travelmanagement.R
import com.sagrd.travelmanagement.adapters.ViajeAdapter
import com.sagrd.travelmanagement.databinding.ViajesListFragmentBinding
import com.sagrd.travelmanagement.model.Viaje

class ViajesListFragment : Fragment() {

    companion object {
        fun newInstance() = ViajesListFragment()
    }

    private var _binding: ViajesListFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ViajesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = ViajesListFragmentBinding.inflate(inflater, container, false)
        viewModel =
            ViewModelProvider(this, ViajesListViewModel.Factory(requireActivity().application))
                .get(ViajesListViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter =ViajeAdapter()

        viewModel.list.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
        binding.listaRecyclerView.adapter = adapter

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_viajesListFragment_to_estadoViajeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}