package com.example.mod4question

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.mod4question.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.net.CacheResponse
import java.net.ResponseCache

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val listQR = listOf(
        Question("est ce que la terre est plate ??", true),
        Question("toto", true),
        Question("titi", false),
        Question("Citi", false)
    )

    var index = 0
    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.question = listQR[index]

        binding.buttonTrue.setOnClickListener{
            if (index +1 > listQR.size -1){
                binding.buttonTrue.isEnabled = false
                binding.buttonFalse.isEnabled = false
                return@setOnClickListener;
            }
            checkUserReponse(true)
            index++
            binding.question = listQR[index]
        }
        binding.buttonFalse.setOnClickListener{
            checkUserReponse(false)
            if (index +1 > listQR.size -1){
                binding.buttonTrue.isEnabled = false
                binding.buttonFalse.isEnabled = false
                return@setOnClickListener;
            }
            val a = index++
            val b = index
            binding.question = listQR[index]
        }

    }
    fun checkUserReponse(userResponse: Boolean) {
        if (userResponse == listQR[index].reponse){
            binding.textViewScore.text = (++score).toString()
        }
    }

}