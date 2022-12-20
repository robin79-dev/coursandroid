package com.example.mod7tp1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DiceViewModel :ViewModel() {
    var value = 0
    val valueDice = MutableLiveData(0)

    fun dice(result : Int){
        valueDice.value = (0..result).random()
    }

}