package com.example.mod8tp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CityViewModel: ViewModel() {
    val listCity = mapOf(
        "Niort" to City("Niort", "79000", "Nouvelle Aquitaine"),
        "Rennes" to City("Rennes", "35000", "Bretagne"),
        "Lille" to City("Lille", "59000", "Haute de France"),
        "Marseille" to City("Marseille", "13000", "PACA"),
        "Lyon" to City("Lyon", "69000", "Auvergne Rhones Alpes"),
        "Nantes" to City("Nantes", "44000", "Pays de la Loire")
    )

val city = MutableLiveData<City>()
val temperature = MutableLiveData<Int>(0)

    init {
        city.value = City("", "0", "")
    }

    fun getTemp(city: City){
        this.city.value = city
         when(city.city){
            "Niort" -> temperature.value = (-5..25).random()
            "Rennes" -> temperature.value = (-10..20).random()
            "Lille" -> temperature.value = (5..25).random()
            "Marseille" -> temperature.value = (5..25).random()
            "Lyon" -> temperature.value = (5..25).random()
            "Nantes" -> temperature.value = (5..25).random()
        }
    }

}