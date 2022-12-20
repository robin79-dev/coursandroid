package com.example.mod9room

import androidx.lifecycle.*
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.launch

class PokemonViewModel(val pokemonDao: PokemonDao):ViewModel() {
    val pokemon = MutableLiveData<Pokemon?>(null)

    fun fetchPokemonById(id:Long){
        viewModelScope.launch{
            pokemon.value = pokemonDao.get(id)
        }
    }
    fun addPokemon(pokemon:Pokemon) : LiveData<Long>{
        val result = MutableLiveData<Long>()
        viewModelScope.launch {
            result.value = pokemonDao.insert(pokemon)
        }
        return result
    }
    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras):T{
                val application = checkNotNull(extras[APPLICATION_KEY])
                return PokemonViewModel(AppDatabase.getInstance(application.applicationContext).pokemonDao()) as T
            }
        }
    }
}
