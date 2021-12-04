package com.sagrd.travelmanagement.repository

import com.sagrd.travelmanagement.data.AppDataBase
import com.sagrd.travelmanagement.model.Venta
import com.sagrd.travelmanagement.network.RetrofitInstance
import com.sagrd.travelmanagement.ui.cobro.FacturasPendienteFragment

class VentaRepository(private val database: AppDataBase)
{
    val cliente = FacturasPendienteFragment()
    suspend fun Get() : List<Venta>
    {
        var listaVenta = emptyList<Venta>().toMutableList()

        for(i in RetrofitInstance.api.getVentas().indices)
        {
            if(RetrofitInstance.api.getVentas()[i].balance != 0f)
            {
                listaVenta.add(RetrofitInstance.api.getVentas()[i])
            }
        }
        return listaVenta
    }
}