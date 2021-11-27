package com.sagrd.travelmanagement.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.sagrd.travelmanagement.adapters.VentaAdapter
import com.sagrd.travelmanagement.adapters.ViajeAdapter
import com.sagrd.travelmanagement.databinding.FacturasPendienteFragmentBinding
import com.sagrd.travelmanagement.databinding.FacturasPendienteRowBinding

class FacturasPendienteFragment : Fragment(), VentaAdapter.onVentaClickListener {

    companion object {
        fun newInstance() = FacturasPendienteFragment()
    }

    private lateinit var viewModel: FacturasPendienteViewModel
    private lateinit var row: FacturasPendienteRowBinding

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

        val adapter = VentaAdapter(this)
        binding.facturasPendienteRecyclerView.adapter = adapter

        viewModel.list.observe(viewLifecycleOwner, Observer{
            adapter.submitList(it)
        })

        binding.facturasPendienteRecyclerView.
        addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCheckClick(ViajeId: Long) {
        //row.facturaCheckBox.isChecked = true
        binding.totalResultadotextView.text = "100"
        Toast.makeText(context,"Funciona", Toast.LENGTH_SHORT).show()
    }
}