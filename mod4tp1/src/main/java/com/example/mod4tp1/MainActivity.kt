package com.example.mod4tp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextMin = findViewById<EditText>(R.id.editTextMin)
        val editTextMax = findViewById<EditText>(R.id.editTextMax)
        val buttonGen = findViewById<Button>(R.id.buttonGenerate)
        val result = findViewById<TextView>(R.id.resultGen)

        buttonGen.setOnClickListener{
            val min = editTextMin.text.toString()
            val max = editTextMax.text.toString()

            val nextValues =  Random.nextInt(min.toInt(), max.toInt())

            result.text = nextValues.toString()
        }
    }
}