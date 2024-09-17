package com.sagrd.travelmanagement.adapters


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.sagrd.travelmanagement.R
import com.sagrd.travelmanagement.data.AppDataBase
import com.sagrd.travelmanagement.databinding.BalanceViajeRowBinding
import com.sagrd.travelmanagement.model.Clientes
import com.sagrd.travelmanagement.model.Documentos
import com.sagrd.travelmanagement.model.Tarjetas
import com.sagrd.travelmanagement.repository.documentosRepository
import com.sagrd.travelmanagement.ui.balanceviaje.BalancesDeViajeViewModel
import kotlinx.coroutines.launch


class BalanceViajeAdapter(): RecyclerView.Adapter<BalanceViajeAdapter.BalanceViajeViewHolder>() {
        private var tarjetasList = emptyList<Tarjetas>()
        private var documentoList = emptyList<Documentos>()

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): BalanceViajeViewHolder {
            val binding =BalanceViajeRowBinding
                .inflate(LayoutInflater.from(parent.context),parent,false)

            return BalanceViajeViewHolder(binding)
        }

        override fun onBindViewHolder(holder: BalanceViajeViewHolder, position: Int) {
            holder.bind(tarjetasList[position]/*,documentoList*/)
        }

        override fun getItemCount(): Int {
            return tarjetasList.size
        }

        fun sumitList(list: List<Tarjetas>/*,listdocument :List<Documentos>*/){
            tarjetasList = list
           // documentoList = listdocument
            notifyDataSetChanged()
        }

        inner class BalanceViajeViewHolder(private val binding:BalanceViajeRowBinding ) :
            RecyclerView.ViewHolder(binding.root) {


            fun bind(item: Tarjetas/*, listaDocu :List<Documentos>*/) {

              // var hola =//BalancesDeViajeViewModel

//                var monto = 0.0
//                for (i in listaDocu.indices)
//                    monto = monto + listaDocu.get(i).balance

                binding.constraintadacterbalanceviaje.setOnClickListener(){
                    val bundle = bundleOf(
                        "tarjetaId" to item.tarjetaId
                    )
                    binding.root.findNavController().navigate(R.id.estadoViajeFragment,bundle)
                }
                binding.NombreClienteTextView.text = item.descripcion
                binding.CostoClienteTextView.text ="0"// monto.toString()
            }
        }
}
