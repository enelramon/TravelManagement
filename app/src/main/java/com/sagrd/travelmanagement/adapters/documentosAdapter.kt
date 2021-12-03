package com.sagrd.travelmanagement.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sagrd.travelmanagement.databinding.EstadoViajeRowBinding
import com.sagrd.travelmanagement.model.Documentos
import java.text.SimpleDateFormat
import java.util.*

class documentosAdapter(): RecyclerView.Adapter<documentosAdapter.DocumentoViewHolder>() {
    private var documentosList = emptyList<Documentos>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocumentoViewHolder {
        val binding =
            EstadoViajeRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return DocumentoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DocumentoViewHolder, position: Int) {
        holder.bind(documentosList[position])
    }

    override fun getItemCount(): Int {
        return documentosList.size
    }

    fun submitList(list: List<Documentos>)
    {
        documentosList = list
        notifyDataSetChanged()
    }


    inner class DocumentoViewHolder(private val binding: EstadoViajeRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Documentos) {
            val fechaFormateada = item.fecha.replaceRange(9,item.fecha.length,"")
            binding.fechaTextView.text = fechaFormateada
            binding.conceptoTextView.text = item.concepto
            binding.montoTextView.text = item.monto.toString()
            binding.balanceTextView.text = item.balance.toString()
        }
    }
}