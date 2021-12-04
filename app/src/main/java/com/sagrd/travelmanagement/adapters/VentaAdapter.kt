package com.sagrd.travelmanagement.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.sagrd.travelmanagement.databinding.FacturasPendienteFragmentBinding
import com.sagrd.travelmanagement.databinding.FacturasPendienteRowBinding
import com.sagrd.travelmanagement.model.Cliente
import com.sagrd.travelmanagement.model.Venta
import com.sagrd.travelmanagement.model.Viaje
import com.sagrd.travelmanagement.utils.showMessage
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class VentaAdapter(private var itemClickListener: VentaAdapter.onVentaClickListener) : RecyclerView.Adapter<VentaAdapter.VentaViewHolder>() {

    private var ventaList = emptyList<Venta>()

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

    fun submitList(list: List<Venta>)
    {
        ventaList = list
        notifyDataSetChanged()
    }

    inner class VentaViewHolder(private val binding: FacturasPendienteRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Venta) {
            try {
                val fechaFormateada = item.fecha.replaceRange(9,item.fecha.length,"")
                binding.facturaIdTextView.text = item.ventaId.toString()
                binding.fechaTextView.text = fechaFormateada
                binding.balanceTextView.text = item.balance.toString()

                itemView.setOnClickListener { itemClickListener.onItemClick(item, binding.linearLayout ) }
            }catch (e: Exception)
            {

            }
        }
    }

    interface onVentaClickListener{
        fun onItemClick(data: Venta, linearLayout: LinearLayout)
    }

}