package com.example.mod7instancestate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mod7instancestate.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputLayout.LengthCounter

class MainActivity : AppCompatActivity() {
    lateinit var textViewCounter: TextView
    lateinit var  fabAdd : FloatingActionButton
    //var count = 0 //inférance de type
    lateinit var viewModel: CounterViewModel
    lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding=DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[CounterViewModel::class.java]
        textViewCounter = findViewById(R.id.textViewCounter)
        fabAdd = findViewById(R.id.fabAdd)
        fabAdd.setOnClickListener{
            viewModel.increment()
            textViewCounter.text = viewModel.count.toString()
        }
    }



    //override fun onSaveInstanceState(outState: Bundle) {
    //    super.onSaveInstanceState(outState)
    //    outState.putInt("counter", count)
    //}
//
    //override fun onRestoreInstanceState(savedInstanceState: Bundle) {
    //    super.onRestoreInstanceState(savedInstanceState)
    //    count = savedInstanceState.getInt("counter")
    //    textViewCounter.text = count.toString()
    //}
}