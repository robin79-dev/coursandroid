package com.example.mod7instancestate

import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
    var count = (0..10).random()

    fun increment() = count
}