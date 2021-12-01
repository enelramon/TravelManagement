package com.sagrd.travelmanagement.ui.gastoviaje

import android.icu.util.Calendar
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
import com.sagrd.travelmanagement.model.Viaje
import com.sagrd.travelmanagement.utils.getFloat
import com.sagrd.travelmanagement.utils.showMessage
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
            if (!Validar()) {
                it.showMessage("Verifique los errores para continuar")
            } else {
                viewModel.Insert(LlenaClase())
                it.showMessage("Viaje guardado")
                findNavController().navigate(R.id.estadoViajeFragment)
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
                it.error = "Debe introducir un monto válido"
                esValido = false
            } else
                it.error = null
        }

        binding.conceptoTextInputEditText.let {
            if (it.text.isNullOrEmpty()) {
                it.error = "Debe introducir un concepto válido"
                esValido = false
            } else
                it.error = null
        }

        return esValido
    }

    fun LlenaClase() : Gasto {
        return Gasto(
            0,
            Calendar.getInstance().time as Date,
            1,
            binding.conceptoTextInputEditText.text.toString(),
            binding.montoTextInputEditText.text.getFloat()
        )
    }
}