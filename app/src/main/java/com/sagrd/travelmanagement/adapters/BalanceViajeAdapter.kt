package com.sagrd.travelmanagement.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sagrd.travelmanagement.databinding.BalanceViajeRowBinding
import com.sagrd.travelmanagement.model.Cliente


class BalanceViajeAdapter(): RecyclerView.Adapter<BalanceViajeAdapter.BalanceViajeViewHolder>() {
        private var traverList = emptyList<Cliente>()

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

        fun sumitList(list: List<Cliente>){
            traverList = list
            notifyDataSetChanged()
        }

        inner class BalanceViajeViewHolder(private val binding:BalanceViajeRowBinding ) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(item: Cliente) {
                binding.NombreClienteTextView.text = item.nombres
                binding.CostoClienteTextView.text = item.balance.toString()
            }
        }
}
