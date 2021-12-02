package com.sagrd.travelmanagement.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sagrd.travelmanagement.model.Cliente


@Dao
interface ClientesDao {
    @Insert
    suspend fun Insert(clientes: Cliente)

    @Update
    suspend fun Update(clientes: Cliente)

    @Query("SELECT * FROM Cliente WHERE clienteId= :key")
    fun Find(key:Long): LiveData<Cliente>

    @Query("SELECT * FROM Cliente ORDER BY clienteId ASC")
    fun Lista() : LiveData<List<Cliente>>
}