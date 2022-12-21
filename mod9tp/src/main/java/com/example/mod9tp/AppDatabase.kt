package com.example.mod9tp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [QualiteAir::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun qualiteAirDao() : QualiteAirDao

    companion object{
        private var INSTANCE : AppDatabase? = null
        fun getInstance(context: Context) : AppDatabase{
            var instance = INSTANCE
            if(instance == null){
                instance = Room.databaseBuilder(
                    context,AppDatabase::class.java,"qualiteAir")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
            }
            return instance
        }
    }
}