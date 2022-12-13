package com.example.mod4databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mod4databinding.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.textView.text = "Toto"

        binding.button.setOnClickListener {
            val editTextVal = binding.editText.text.toString()
            Snackbar.make(it, editTextVal, Snackbar.LENGTH_SHORT).show()
        }
        val jeff = User("jeff", "bezos", 58, "Ohio")
        binding.user = jeff

    }
}