package com.example.mod5nav

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(val prenom : String, val nom : String) : Parcelable
