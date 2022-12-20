package com.example.mod9room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mod9room.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val viewModel : PokemonViewModel by viewModels(){PokemonViewModel.Factory}
    lateinit var  db : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = DataBindingUtil.setContentView(this, R.layout.activity_main)
        db.vm = viewModel
        db.lifecycleOwner = this
        viewModel.addPokemon(Pokemon(0L, "Pikachu", 35, Type.ELECTRIQUE, 55))
            .observe(this){
            viewModel.fetchPokemonById(it!!)
        }
    }
}