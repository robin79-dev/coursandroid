package com.example.mod7tp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mod7tp1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var viewModel : DiceViewModel
    lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel=ViewModelProvider(this)[DiceViewModel::class.java]
        dataBinding.vm=viewModel

        dataBinding.button10.setOnClickListener{
            viewModel.dice(10)
           dataBinding.vm=viewModel
        }
        dataBinding.button12.setOnClickListener{
            viewModel.dice(12)
            dataBinding.vm=viewModel
        }
        dataBinding.button24.setOnClickListener{
            viewModel.dice(24)
            dataBinding.vm=viewModel
        }
        dataBinding.button32.setOnClickListener{
            viewModel.dice(32)
            dataBinding.vm=viewModel
        }
    }
}