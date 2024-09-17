package com.sagrd.travelmanagement.data


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sagrd.travelmanagement.model.*



@Database(
    entities = [Viaje::class, Gasto::class, Seguimiento::class],
    version = 5,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {

    abstract val viajeDao: ViajeDao
    abstract val gastoDao: GastoDao
    abstract val seguimientoDao : SeguimientoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getInstance(context:Context): AppDataBase{
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDataBase::class.java,
                        "TravelDb"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}
