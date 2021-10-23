package com.sagrd.travelmanagement.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sagrd.travelmanagement.model.Viaje

@Database(
    entities = [Viaje::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {

    abstract val viajeDao: ViajeDao

    companion object {
        private const val DATABASE_NAME = "TravelDb"

        @Volatile
        private var INSTANCE: AppDataBase? = null

        private fun buildDataBase(context: Context): AppDataBase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                DATABASE_NAME
            ).build()
        }

        fun getInstance(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                buildDataBase(context).also { INSTANCE = it }
            }
        }
    }
}
