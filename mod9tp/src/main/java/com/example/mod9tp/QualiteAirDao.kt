package com.example.mod9tp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface QualiteAirDao {
    @Insert
    suspend fun insert(qualiteAir: QualiteAir) : Long

    @Query("SELECT * FROM QualiteAir")
    suspend fun getAll(): List<QualiteAir>

    @Update
    suspend fun update(qualiteAir: QualiteAir) : Int

    @Delete
    suspend fun delete(qualiteAir: QualiteAir) : Int
}