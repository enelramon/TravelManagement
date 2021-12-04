package com.sagrd.travelmanagement.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.sagrd.travelmanagement.R
import com.sagrd.travelmanagement.databinding.BalanceViajeRowBinding
import com.sagrd.travelmanagement.model.Clientes


class BalanceViajeAdapter(): RecyclerView.Adapter<BalanceViajeAdapter.BalanceViajeViewHolder>() {
        private var traverList = emptyList<Clientes>()

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): BalanceViajeViewHolder {
            val binding =BalanceViajeRowBinding
                .inflate(LayoutInflater.from(parent.context),parent,false)

            return BalanceViajeViewHolder(binding)
        }

        override fun onBindViewHolder(holder: BalanceViajeViewHolder, position: Int) {
            holder.bind(traverList[position])
        }

        override fun getItemCount(): Int {
            return traverList.size
        }

        fun sumitList(list: List<Clientes>){
            traverList = list
            notifyDataSetChanged()
        }

        inner class BalanceViajeViewHolder(private val binding:BalanceViajeRowBinding ) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(item: Clientes) {


                binding.constraintadacterbalanceviaje.setOnClickListener(){
                    val bundle = bundleOf(
                        "ClienteId" to item.clienteId,
                    )
                    binding.root.findNavController().navigate(R.id.estadoViajeFragment,bundle)
                }
                binding.NombreClienteTextView.text = item.nombres
                binding.CostoClienteTextView.text = item.balance.toString()
            }
        }
}
