package com.sagrd.travelmanagement.ui

import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.sagrd.travelmanagement.R
import com.sagrd.travelmanagement.databinding.ViajeEditFragmentBinding
import com.sagrd.travelmanagement.model.Viaje
import com.sagrd.travelmanagement.network.RetrofitInstance
import com.sagrd.travelmanagement.utils.getFloat
import com.sagrd.travelmanagement.utils.showMessage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DateFormat

class ViajeEditFragment : Fragment() {

    companion object {
        fun newInstance() = ViajeEditFragment()
    }

    private lateinit var viewModel: ViajeEditViewModel

    private var _binding: ViajeEditFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = ViajeEditFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =
            ViewModelProvider(this, ViajeEditViewModel.Factory(requireActivity().application))
                .get(ViajeEditViewModel::class.java)


        binding.guardarButton.setOnClickListener {
            if (!Validar()) {
                it.showMessage("Verifique los errores para continuar")
            } else {
                viewModel.Post(LlenaClase())
//                viewModel.Insert(LlenaClase())
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

        binding.millasTextInputEditText.let {
            if (it.text.getFloat() <= 0) {
                it.error = "Debe introducir un monto válido"
                esValido = false
            } else
                it.error = null
        }

        binding.conceptoTextInputEditText.let {
            if (it.text.isNullOrEmpty()) {
                it.error = "Debe introducir una observación valida"
                esValido = false
            } else
                it.error = null
        }

        return esValido
    }

    fun LlenaClase() : Viaje {
        var fecha = Calendar.getInstance().time as java.util.Date
        DateFormat.getDateInstance(DateFormat.SHORT).format(fecha)
        return Viaje(
            0,
            "2021-11-25T01:48:33",
            1,
            binding.conceptoTextInputEditText.text.toString(),
            binding.millasTextInputEditText.text.getFloat(),
            57.25F,
            (binding.millasTextInputEditText.text.getFloat() * 57.25F)
        )
    }

}




