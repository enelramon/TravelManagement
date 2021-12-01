package com.sagrd.travelmanagement.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sagrd.travelmanagement.databinding.EstadoViajeRowBinding
import com.sagrd.travelmanagement.databinding.EstadoViajeRowBinding.inflate
import com.sagrd.travelmanagement.model.Gasto
import com.sagrd.travelmanagement.model.Viaje
import java.text.DateFormat
import java.text.DecimalFormat
import kotlin.math.round

class ViajeAdapter : RecyclerView.Adapter<ViajeAdapter.ViajeViewHolder>() {
    private var viajesList = emptyList<Viaje>()

    fun submitList(list: List<Viaje>)
    {
        viajesList = list
        notifyDataSetChanged()
    }

    inner class ViajeViewHolder(val binding: EstadoViajeRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Viaje) {
            binding.fechaTextView.text = item.fecha
            binding.conceptoTextView.text = item.concepto
            binding.montoTextView.text = round(item.monto).toString()
        }
    }
//    DateFormat.getDateInstance(DateFormat.SHORT).format(item.fecha).toString()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViajeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = inflate(inflater, parent, false)

        return ViajeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViajeViewHolder, position: Int) {
        val viaje = viajesList[position]
        holder.bind(viaje)
    }

    override fun getItemCount(): Int {
        return viajesList.size
    }
}