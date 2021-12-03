package com.sagrd.travelmanagement.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sagrd.travelmanagement.R
import com.sagrd.travelmanagement.adapters.ClientesAdapter
import com.sagrd.travelmanagement.adapters.VentaAdapter
import com.sagrd.travelmanagement.databinding.ClienteRowBinding
import com.sagrd.travelmanagement.databinding.ClientesFragmentBinding


class ClientesFragment : Fragment(R.layout.clientes_fragment) {

    companion object {
        fun newInstance() = ClientesFragment()
    }

    private lateinit var viewModel: ClientesViewModel
    lateinit var  clientesAdapter: ClientesAdapter
    private var _binding : ClientesFragmentBinding? = null
    private val binding get() = _binding!!

    private var _bindingRow : ClienteRowBinding? = null
    private val bindingRow get() = _bindingRow

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
            val adapter = ClientesAdapter()
            adapter.submitList(it)
            binding.ClientesRecyclerView.adapter = adapter
        })

        binding.ClientesRecyclerView.setOnClickListener{

        }
//        clientesAdapter.setOnItemClickListener {
//            val bundle = Bundle()
//            bundle.putLong("cienteId",)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}