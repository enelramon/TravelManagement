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
            findNavController().navigate(R.id.estadoViajeFragment)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}