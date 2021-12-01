package com.sagrd.travelmanagement.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sagrd.travelmanagement.model.Viaje

@Dao
interface ViajeDao {
    @Insert
    suspend fun Insert(viaje: Viaje)

    @Update
    suspend fun Update(viaje: Viaje)

    @Query("SELECT * FROM Viaje WHERE travelId= :key")
     fun Find(key:Long): LiveData<Viaje>

    @Query("SELECT * FROM Viaje ORDER BY travelId DESC")
     fun Lista() :LiveData<List<Viaje>>
}

