package com.sagrd.travelmanagement

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.sagrd.travelmanagement.data.AppDataBase
import com.sagrd.travelmanagement.data.CobroDao
import com.sagrd.travelmanagement.model.Cobro
import com.sagrd.travelmanagement.model.CobroDetalle
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.time.LocalDate
import java.time.LocalDate.now
import java.util.*
import kotlin.jvm.Throws

@RunWith(AndroidJUnit4::class)
class CobrosInstrumentedTest {

    private lateinit var db: AppDataBase
    private lateinit var cobroDao: CobroDao

    @Before
    fun createDb(){
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        db = Room.inMemoryDatabaseBuilder(context,AppDataBase::class.java)
            .allowMainThreadQueries()
            .build()
    }

    @After
    @Throws(IOException::class)
    fun closeDb()
    {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertCobro(){

        val detalle = listOf<CobroDetalle>()
        val cobro = Cobro(0, Date(),1,100.0f,detalle)

    }
}