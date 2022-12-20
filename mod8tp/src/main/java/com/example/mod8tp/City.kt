package com.example.mod8tp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class City(val city : String, val postcode : String, val region : String):Parcelable
