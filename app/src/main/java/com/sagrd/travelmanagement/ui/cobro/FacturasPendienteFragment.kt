package com.sagrd.travelmanagement.ui.cobro

import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import com.sagrd.travelmanagement.R
import com.sagrd.travelmanagement.adapters.VentaAdapter
import com.sagrd.travelmanagement.databinding.FacturasPendienteFragmentBinding
import com.sagrd.travelmanagement.model.Cobro
import com.sagrd.travelmanagement.model.CobroDetalle
import com.sagrd.travelmanagement.model.Venta
import com.sagrd.travelmanagement.utils.showMessage
import java.text.SimpleDateFormat
import java.util.*

class FacturasPendienteFragment : Fragment(R.layout.facturas_pendiente_fragment), VentaAdapter.onVentaClickListener  {

    companion object {
        fun newInstance() = FacturasPendienteFragment()
    }

    private lateinit var viewModel: FacturasPendienteViewModel

    private var _binding: FacturasPendienteFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FacturasPendienteFragmentBinding.inflate(inflater, container, false)

        viewModel =
            ViewModelProvider(
                this,
                FacturasPendienteViewModel.Factory(requireActivity().application)
            )
                .get(FacturasPendienteViewModel::class.java)

        //ahora recibiras la variable tarjetaId
        val clienteId = arguments?.getLong("clienteId")!!.toInt()

        viewModel.listaVentasApi.observe(viewLifecycleOwner, Observer{
            val adapter = VentaAdapter(this)
            adapter.submitList(it)
            binding.facturasPendienteRecyclerView.adapter = adapter
        })

        //Aqui debe digitarse el valor del argumento
        binding.guardarButton.text = clienteId.toString()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.facturasPendienteRecyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )

        binding.guardarButton.setOnClickListener{
            if(cobroDetalleList.isNotEmpty())
            {
                viewModel.Post(LlenaClase())
                it.showMessage("Cobro Guardado exitosamente")
                findNavController().navigate(R.id.facturasPendienteFragment)
            }
            else
                it.showMessage("No se ha seleccionado ningún item")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    var acumulador = 0f
    var cobroDetalleList = emptyList<CobroDetalle>().toMutableList()

    override fun onItemClick(item: Venta, linearLayout: LinearLayout) {

        val cobroDetalle = CobroDetalle(
            0,
            0,
            item.ventaId,
            item.balance
        )

        linearLayout.setBackgroundColor(Color.parseColor("#81C784"))
            if(cobroDetalleList.contains(cobroDetalle))
            {
                acumulador -= cobroDetalle.cobrado
                binding.totalResultadotextView.text = acumulador.toString()
                linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"))
                cobroDetalleList.remove(cobroDetalle)
            }else{
                cobroDetalleList.add(cobroDetalle)
                acumulador += cobroDetalle.cobrado
                binding.totalResultadotextView.text = acumulador.toString()
            }
    }

    fun  LlenaClase(): Cobro
    {
        val formatoFecha = SimpleDateFormat("yyyy-M-dd")
        val fecha = formatoFecha.format(Date())

        return Cobro(
            0,
            fecha.toString()+ "T01:00:00",
            1,
            acumulador,
            cobroDetalleList
        )
    }

}