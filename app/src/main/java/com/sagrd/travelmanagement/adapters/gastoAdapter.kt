package com.sagrd.travelmanagement.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sagrd.travelmanagement.databinding.EstadoViajeRowBinding
import com.sagrd.travelmanagement.model.Gasto
import kotlin.math.round

class gastoAdapter(  ) : RecyclerView.Adapter<gastoAdapter.GastoViewHolder>() {
    private var gastoList = emptyList<Gasto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GastoViewHolder {
        val binding =
            EstadoViajeRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return GastoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GastoViewHolder, position: Int) {
        holder.bind(gastoList[position])
    }

    override fun getItemCount(): Int {
        return gastoList.size
    }

    fun submitList(list: List<Gasto>)
    {
        gastoList = list
        notifyDataSetChanged()
    }


    inner class GastoViewHolder(private val binding: EstadoViajeRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Gasto) {
            binding.fechaTextView.text = item.fecha
            binding.conceptoTextView.text = item.concepto
            binding.montoTextView.text = round(item.monto).toString()
        }
    }
}