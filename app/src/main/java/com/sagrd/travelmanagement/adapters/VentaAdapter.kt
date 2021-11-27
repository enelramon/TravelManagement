package com.sagrd.travelmanagement.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sagrd.travelmanagement.databinding.FacturasPendienteRowBinding
import com.sagrd.travelmanagement.model.Venta
import com.sagrd.travelmanagement.model.Viaje
import java.text.DateFormat

class VentaAdapter( private var itemClickListener: VentaAdapter.onVentaClickListener) : RecyclerView.Adapter<VentaAdapter.VentaViewHolder>() {
    private var ventaList = emptyList<Viaje>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VentaViewHolder {
        val binding =
            FacturasPendienteRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return VentaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VentaViewHolder, position: Int) {
        holder.bind(ventaList[position])

    }

    override fun getItemCount(): Int {
        return ventaList.size
    }

    fun submitList(list: List<Viaje>)
    {
        ventaList = list
        notifyDataSetChanged()
    }

    inner class VentaViewHolder(private val binding: FacturasPendienteRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Viaje) {
            binding.facturaCheckBox.isChecked = false
            binding.facturaIdTextView.text = item.ViajeId.toString()
            binding.fechaTextView.text = DateFormat.getDateInstance(DateFormat.SHORT).format(item.Fecha)
            binding.balanceTextView.text = item.Monto.toString()

            itemView.setOnClickListener{itemClickListener.onCheckClick(item.ViajeId)}
        }
    }

    interface onVentaClickListener{
        fun onCheckClick(ViajeId: Long)
    }
}