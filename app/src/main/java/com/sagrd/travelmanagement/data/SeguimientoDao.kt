package com.sagrd.travelmanagement.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sagrd.travelmanagement.model.Seguimiento

@Dao
interface SeguimientoDao {
    @Insert
    suspend fun Insert(seguimiento: Seguimiento)

    @Update
    suspend fun Update(seguimiento: Seguimiento)

    @Query("SELECT * FROM Seguimiento WHERE seguimientoId = :key")
    fun Find(key:Long) : LiveData<Seguimiento>

    @Query("SELECT * FROM Seguimiento ORDER BY seguimientoId DESC")
    fun Lista() : LiveData<List<Seguimiento>>
}