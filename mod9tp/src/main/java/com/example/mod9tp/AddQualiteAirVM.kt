package com.example.mod9tp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.mod9tp.QualiteAirDao
import kotlinx.coroutines.launch

class AddQualiteAirVM(val dao: QualiteAirDao) : ViewModel() {
    fun addQualiteAir(qualiteAir: QualiteAir){
        viewModelScope.launch {
            dao.insert(qualiteAir)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras):T{
                val application = checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
                return AddQualiteAirVM(AppDatabase.getInstance(application.applicationContext).qualiteAirDao()) as T
            }
        }
    }

}