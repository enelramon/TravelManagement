package com.sagrd.travelmanagement.ui.gastoviaje

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.sagrd.travelmanagement.R
import com.sagrd.travelmanagement.databinding.GastoViajeFragmentBinding
import com.sagrd.travelmanagement.model.Gasto
import com.sagrd.travelmanagement.utils.getFloat
import com.sagrd.travelmanagement.utils.showMessage
import java.text.SimpleDateFormat
import java.util.*

class GastoViajeFragment : Fragment() {

    companion object {
        fun newInstance() = GastoViajeFragment()
    }

    private lateinit var viewModel: GastoViajeViewModel

    private var _binding : GastoViajeFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = GastoViajeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =
            ViewModelProvider(this, GastoViajeViewModel.Factory(requireActivity().application))
                .get(GastoViajeViewModel::class.java)



        binding.guardarButton.setOnClickListener{
            val int = arguments?.getLong("tarjetaId")!!.toInt()
            if (!Validar()) {
                it.showMessage("Verifique los errores para continuar")
            } else {
                viewModel.Post(LlenaClase(int))
                it.showMessage("Gasto guardado")
                findNavController().navigateUp()
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    fun Validar(): Boolean {
        var esValido = true;

        binding.montoTextInputEditText.let {
            if (it.text.getFloat() <= 0) {
                it.error = "Debe introducir un monto v??lido"
                esValido = false
            } else
                it.error = null
        }

        binding.conceptoTextInputEditText.let {
            if (it.text.isNullOrEmpty()) {
                it.error = "Debe introducir un concepto v??lido"
                esValido = false
            } else
                it.error = null
        }

        return esValido
    }

    fun LlenaClase(id : Int) : Gasto {
        val formatoFecha = SimpleDateFormat("yyyy-M-dd")
        val fecha = formatoFecha.format(Date())
        return Gasto(
            0,
            fecha.toString()+"T01:00:00",
            id.toLong(),
            binding.conceptoTextInputEditText.text.toString(),
            binding.montoTextInputEditText.text.getFloat()
        )
    }
}