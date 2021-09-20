package com.solulab.assignment.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import kotlin.jvm.Volatile
import androidx.room.Room
import com.solulab.assignment.data.model.CoinPictureData
import com.solulab.assignment.data.model.CoinsData
import com.solulab.assignment.data.model.ProfileData
import com.solulab.assignment.data.model.UserData
import java.util.concurrent.Executors

@Database(entities = [CoinsData::class, CoinPictureData::class, UserData::class, ProfileData::class], version = 1, exportSchema = false)
abstract class CoinDatabase : RoomDatabase() {

    abstract fun coinDao(): CoinDao?

    companion object {
        private var INSTANCE: CoinDatabase? = null
        @JvmStatic
        fun getDatabase(context: Context): CoinDatabase? {
            if (INSTANCE == null) {
                synchronized(CoinDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                            CoinDatabase::class.java, "coins_database")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}