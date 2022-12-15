package com.example.mod5tp2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Histoire(val prenom: String, val lieu: String): Parcelable
