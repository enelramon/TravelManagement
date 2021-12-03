package com.sagrd.travelmanagement.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sagrd.travelmanagement.databinding.ClienteRowBinding
import com.sagrd.travelmanagement.databinding.ClientesFragmentBinding
import com.sagrd.travelmanagement.model.Cliente
import java.text.SimpleDateFormat
import java.util.*

class ClientesAdapter(): RecyclerView.Adapter<ClientesAdapter.ClientesViewHolder>() {
    private  var clientesList = emptyList<Cliente>()

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


    fun submitList(list: List<Cliente>)
    {
        clientesList = list
        notifyDataSetChanged()
    }


    inner class ClientesViewHolder(private val binding: ClienteRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Cliente) {
            binding.nombreTextView.text= item.nombres
            binding.montoTextView.text = item.balance.toString()

        }
    }

    private var onItemClickListener: ((Cliente) -> Unit)? = null

    fun setOnItemClickListener(listener: (Cliente) -> Unit) {
        onItemClickListener = listener
    }
}