package com.sagrd.travelmanagement.ui

import android.icu.util.Calendar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.sagrd.travelmanagement.R
import com.sagrd.travelmanagement.databinding.ViajeEditFragmentBinding
import com.sagrd.travelmanagement.model.Viaje
import com.sagrd.travelmanagement.utils.getFloat
import com.sagrd.travelmanagement.utils.showMessage

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

//        viewModel.listaSolares.observe(viewLifecycleOwner, Observer{
//            binding.conceptoTextInputEditText.setText("${it.size}")
//        })

        binding.guardarButton.setOnClickListener {
            if (!Validar()) {
                it.showMessage("Verifique los errores para continuar")
            } else {
                viewModel.Insert(LlenaClase())
                it.showMessage("Viaje guardado")
                findNavController().navigate(R.id.estadoViajeFragment)
            }
        }


    /*    viewModel.viaje.observe(viewLifecycleOwner, Observer {
            LlenaCampos(it)
        })*/
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
                it.error = "Debe introducir una observación valida"
                esValido = false
            } else
                it.error = null
        }

        return esValido
    }

    fun LlenaClase() : Viaje {
        return Viaje(
            0,
            Calendar.getInstance().time as java.util.Date,
            binding.conceptoTextInputEditText.text.toString(),
            binding.montoTextInputEditText.text.getFloat()
        )
    }

}




