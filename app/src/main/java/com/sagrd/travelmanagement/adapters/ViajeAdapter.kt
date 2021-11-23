package com.sagrd.travelmanagement.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sagrd.travelmanagement.databinding.FacturasPendienteRowBinding
import com.sagrd.travelmanagement.databinding.FacturasPendienteRowBinding.inflate
import com.sagrd.travelmanagement.model.Viaje

class ViajeAdapter(  ) : RecyclerView.Adapter<ViajeAdapter.ViajeViewHolder>() {
    private var viajesList = emptyList<Viaje>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViajeViewHolder {
        val binding = inflate(LayoutInflater.from(parent.context), parent, false)

        return ViajeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViajeViewHolder, position: Int) {
        holder.bind(viajesList[position])
    }

    override fun getItemCount(): Int {
        return viajesList.size
    }

    fun submitList(list: List<Viaje>)
    {
        viajesList = list
        notifyDataSetChanged()
    }

    inner class ViajeViewHolder(private val binding: FacturasPendienteRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Viaje) {
            binding.facturaIdCheckBox.text = item.ViajeId.toString()
            binding.fechaTextView.text = item.Fecha.toString()
            binding.balanceTextView.text = item.Monto.toString()
        }
    }
}