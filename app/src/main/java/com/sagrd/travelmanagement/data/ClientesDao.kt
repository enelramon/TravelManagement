package com.sagrd.travelmanagement.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface ClientesDao {
    @Insert
    suspend fun Insert(clientes: Clientes)

    @Update
    suspend fun Update(clientes: Clientes )

    @Query("SELECT * FROM Clientes WHERE clienteId= :key")
    fun Find(key:Long): LiveData<Clientes>

    @Query("SELECT * FROM Clientes ORDER BY clienteId ASC")
    fun Lista() : LiveData<List<Clientes>>
}