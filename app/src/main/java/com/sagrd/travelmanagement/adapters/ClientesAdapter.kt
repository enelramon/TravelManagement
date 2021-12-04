package com.sagrd.travelmanagement.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.sagrd.travelmanagement.R
import com.sagrd.travelmanagement.databinding.ClienteRowBinding
import com.sagrd.travelmanagement.model.Clientes

class clientesAdapter(): RecyclerView.Adapter<clientesAdapter.ClientesViewHolder>() {
    private  var clientesList = emptyList<Clientes>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientesViewHolder {
        val binding =
            ClienteRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ClientesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ClientesViewHolder, position: Int) {
        holder.bind(clientesList[position])
    }

    override fun getItemCount(): Int {
        return clientesList.size
    }

    fun submitList(list: List<Clientes>)
    {
        clientesList = list
        notifyDataSetChanged()
    }


    inner class ClientesViewHolder(private val binding: ClienteRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Clientes) {

            binding.imageButtoncobro.setOnClickListener(){
                val bundle = bundleOf(
                    "clienteId" to item.clienteId,
                )
                binding.root.findNavController().navigate(R.id.action_clientesFragment_to_facturasPendienteFragment)
            }
            binding.imageButtonseguimineto.setOnClickListener(){
                val bundle = bundleOf(
                    "clienteId" to item.clienteId,
                )
                binding.root.findNavController().navigate(R.id.action_clientesFragment_to_seguimientoClienteFragment)
            }
            binding.nombreTextView.text= item.nombres
            binding.montoTextView.text = item.balance.toString()

        }
    }
}