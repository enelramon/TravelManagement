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
import com.sagrd.travelmanagement.model.Venta
import com.sagrd.travelmanagement.model.Viaje
import com.sagrd.travelmanagement.utils.showMessage
import java.text.DateFormat

class VentaAdapter( private var itemClickListener: VentaAdapter.onVentaClickListener) : RecyclerView.Adapter<VentaAdapter.VentaViewHolder>() {

    private var ventaList = emptyList<Venta>()

    var acumulador = 0f

    private var _binding: FacturasPendienteRowBinding? = null
    private val binding get() = _binding!!

    private var _access: FacturasPendienteFragmentBinding? = null
    private val binding2 get() = _access!!

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
                //binding.facturaCheckBox
                //binding.facturaCheckBox.isClickable = false
                //DateFormat.getDateInstance(DateFormat.SHORT).format(item.fecha)
                binding.facturaIdTextView.text = item.ventaId.toString()
                binding.fechaTextView.text = item.fecha
                binding.balanceTextView.text = item.balance.toString()

                //crear contador que incremente con cada click
                itemView.setOnClickListener { itemClickListener.onItemClick(item, binding.linearLayout ) }
                //itemView.setOnClickListener{itemClickListener.onCheckClick(binding.facturaCheckBox)}
            }catch (e: Exception)
            {

            }
        }
    }

    interface onVentaClickListener{
        fun onItemClick(data: Venta, linearLayout: LinearLayout)
        //activar checkbox
        //crear variable acumulador
        //si contador es par
        //sumar monto a variable
        //si contador es impar
        //restar monto a la variable
    }
}