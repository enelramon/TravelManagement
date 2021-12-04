package com.sagrd.travelmanagement.ui

import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.sagrd.travelmanagement.R
import com.sagrd.travelmanagement.adapters.ClientesAdapter
import com.sagrd.travelmanagement.databinding.ClientesFragmentBinding
import com.sagrd.travelmanagement.model.Cliente


class ClientesFragment : Fragment(R.layout.clientes_fragment), ClientesAdapter.onClienteClickListener {

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

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.listaClientesApi.observe(viewLifecycleOwner, Observer{
            val adapter = ClientesAdapter(this)
            adapter.submitList(it)
            binding.ClientesRecyclerView.adapter = adapter
        })

        binding.seguimientoButton.setOnClickListener{
            val bundle = bundleOf("clienteId" to viewModel.clienteId)
            it.findNavController().navigate(R.id.action_clientesFragment_to_seguimientoClienteFragment, bundle)
        }
        binding.cobroButton.setOnClickListener{
            val bundle = bundleOf("clienteId" to viewModel.clienteId)
            it.findNavController().navigate(R.id.action_clientesFragment_to_facturasPendienteFragment, bundle)
        }

    }

    //Con la lista verificamos si está seleccionado o no
    var clientesList = emptyList<Cliente>().toMutableList()
    private lateinit var clienteTemporal : Cliente

    override fun onItemClick(item: Cliente, linearLayout: LinearLayout) {

        if(clientesList.isNotEmpty())
        {
            clientesList.remove(clienteTemporal)
            linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }else{

            clienteTemporal = item
            clientesList.add(clienteTemporal)
            linearLayout.setBackgroundColor(Color.parseColor("#81C784"))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}