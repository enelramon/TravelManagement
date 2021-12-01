package com.sagrd.travelmanagement.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sagrd.travelmanagement.model.Venta


@Dao
interface VentaDao {
    @Insert
    suspend fun Insert(venta: Venta)

    @Update
    suspend fun Update(venta: Venta)

    @Query("SELECT * FROM Venta WHERE VentaId= :key")
    fun Find(key:Long): LiveData<Venta>

    @Query("SELECT * FROM Venta ORDER BY VentaId ASC")
    fun Lista() : LiveData<List<Venta>>
}
