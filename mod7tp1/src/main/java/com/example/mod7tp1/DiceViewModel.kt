package com.example.mod7tp1

import androidx.lifecycle.ViewModel

class DiceViewModel :ViewModel() {
  var value = 0

    fun dice(result : Int){
        value = (0..result).random()
    }

}