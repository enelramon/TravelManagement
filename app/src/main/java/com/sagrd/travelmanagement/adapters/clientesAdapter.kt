package com.sagrd.travelmanagement.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sagrd.travelmanagement.databinding.ClientesFragmentBinding
import java.text.SimpleDateFormat
import java.util.*

class clientesAdapter(): RecyclerView.Adapter<clientesAdapter.ClientesViewHolder>() {
    private  var clientesList = emptyList<Clientes>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientesViewHolder {
        val binding =
            ClientesFragmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)

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


    inner class ClientesViewHolder(private val binding: ClientesFragmentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Clientes) {
            val fecha = SimpleDateFormat("dd-M-yyyy")
            val fecha3 = fecha.format(Date())
            binding.textView2.text= item.nombre
            binding.textView3 .text = item.monto.toString()

        }
    }
}