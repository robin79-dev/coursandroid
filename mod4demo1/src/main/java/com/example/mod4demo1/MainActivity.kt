package com.example.mod4demo1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewHello = findViewById<TextView>(R.id.textViewHello)
        val editTextTextName = findViewById<EditText>(R.id.editTextTextName)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val button = findViewById<Button>(R.id.button)

        textViewHello.text = "Hello"
        editTextTextName.setHint("Comment aller vous ?")
        ratingBar.progress = 6
        button.setOnClickListener{
            val valEditText = editTextTextName.text.toString()
            if(valEditText == ""){
                Snackbar.make(it, "jgqtzdtugvqzd", Snackbar.LENGTH_SHORT).show()
            }else  {

                Snackbar.make(it, valEditText, Snackbar.LENGTH_SHORT).show()
            }
        }

    }
}