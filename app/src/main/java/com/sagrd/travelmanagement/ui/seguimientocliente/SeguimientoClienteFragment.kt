package com.sagrd.travelmanagement.ui.seguimientocliente

import android.app.DatePickerDialog
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.DatePicker
import com.sagrd.travelmanagement.R
import com.sagrd.travelmanagement.databinding.SeguimientoClienteFragmentBinding
import com.sagrd.travelmanagement.model.Seguimiento
import com.sagrd.travelmanagement.ui.DatePickerFragment
import com.sagrd.travelmanagement.utils.showMessage
import java.text.SimpleDateFormat
import java.util.*


class SeguimientoClienteFragment : Fragment() {

    private var _binding: SeguimientoClienteFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: SeguimientoClienteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = SeguimientoClienteFragmentBinding.inflate(inflater, container, false)

        val lista = resources.getStringArray(R.array.lista)
        val arrayAdapterLista = ArrayAdapter(requireContext(),R.layout.dropdown_item,lista)
        binding.autoCompleteTextView2.setAdapter(arrayAdapterLista)

        val estado = resources.getStringArray(R.array.estado)
        val arrayAdapterEstado = ArrayAdapter(requireContext(),R.layout.dropdown_item,estado)
        binding.autoCompleteTextView.setAdapter(arrayAdapterEstado)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=
            ViewModelProvider(this, SeguimientoClienteViewModel.Factory(requireActivity().application))
                .get(SeguimientoClienteViewModel::class.java)

        binding.guardarButton.setOnClickListener{
            val int = arguments?.getLong("clienteId")!!.toInt()
            viewModel.Post(LlenaClase(int))
            it.showMessage("Guardado")
        }

        agregarfecha()
    }

    fun agregarfecha(){
        val mcurrentTime = Calendar.getInstance()
        val year = mcurrentTime.get(Calendar.YEAR)
        val month = mcurrentTime.get(Calendar.MONTH)
        val day = mcurrentTime.get(Calendar.DAY_OF_MONTH)

        binding.siguienteFecha.setOnClickListener(){
            val datePicker = DatePickerDialog(it.context,android.R.style.ThemeOverlay_Material_Dialog, object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    binding.fechaTextView.setText(String.format("%d-%d-%d", year, month + 1, dayOfMonth))
                }
            }, year, month, day);
            datePicker.show()
        }
    }

    fun LlenaClase(id: Int) : Seguimiento {
        val formatoFecha = SimpleDateFormat("yyyy-M-dd")
        val fecha = formatoFecha.format(Date())

        var opcion = 1L
        if(binding.autoCompleteTextView2.text.toString() == "Correo")
            opcion = 2L
        else if (binding.autoCompleteTextView2.text.toString() == "Visita")
                opcion = 3L

        var opcion2 = 1L
        if(binding.autoCompleteTextView.text.toString() == "Finaliza")
            opcion2 = 2L

        return Seguimiento(
            0,
            fecha.toString()+"T01:00:00",
            id.toLong(),
            binding.ComentarioTextInputEditText.text.toString(),
            opcion,
            opcion2,
            binding.fechaTextView.text.toString() + "T01:00:00"
        )
    }
}