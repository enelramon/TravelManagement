package com.sagrd.travelmanagement.ui.balanceviaje


import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.sagrd.travelmanagement.adapters.BalanceViajeAdapter
import com.sagrd.travelmanagement.databinding.BalancesDeViajeFragmentBinding

class BalancesDeViajeFragment : Fragment() {

    private var _binding :BalancesDeViajeFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: BalancesDeViajeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        _binding = BalancesDeViajeFragmentBinding.inflate(inflater,container,false)
        viewModel =
            ViewModelProvider(this,BalancesDeViajeViewModel.Factory(requireActivity().application))
                .get(BalancesDeViajeViewModel::class.java)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BalancesDeViajeViewModel::class.java)
        // TODO: Use the ViewModel

        viewModel.lista.observe(viewLifecycleOwner, {
            val adapter = BalanceViajeAdapter()
            adapter.sumitList(it)
            binding.balancesviajesRecyclerView.adapter = adapter
        })
        
    }
}