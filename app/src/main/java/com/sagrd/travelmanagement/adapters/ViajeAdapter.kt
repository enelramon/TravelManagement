package com.sagrd.travelmanagement.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.sagrd.travelmanagement.databinding.EstadoViajeRowBinding
import com.sagrd.travelmanagement.databinding.EstadoViajeRowBinding.inflate
import com.sagrd.travelmanagement.model.Gasto
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


    inner class ViajeViewHolder(private val binding: EstadoViajeRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Viaje) {
                binding.fechaTextView.text = item.Fecha.toString()
                binding.conceptoTextView.text = item.Concepto
                binding.montoTextView.text = item.Monto.toString()
        }
    }
}