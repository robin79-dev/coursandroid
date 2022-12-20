package com.example.mod9room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

enum class Type{
    VOL,EAU,PLANTE,FEU,ELECTRIQUE
}

@Entity
data class Pokemon(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nom: String,
    val hp: Int,
    val type: Type,

    @ColumnInfo(name = "power_attack")
    val powerAttack: Int
    )
