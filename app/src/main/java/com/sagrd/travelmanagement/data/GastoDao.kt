package com.sagrd.travelmanagement.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sagrd.travelmanagement.model.Gasto

@Dao
interface GastoDao {
    @Insert
    suspend fun Insert(gasto: Gasto)

    @Update
    suspend fun Update(gasto: Gasto)

    @Query("SELECT * FROM Gasto WHERE GastoId = :key")
    fun Find(key:Long) : LiveData<Gasto>

    @Query("SELECT * FROM Gasto ORDER BY GastoId DESC")
    fun Lista() : LiveData<List<Gasto>>
}