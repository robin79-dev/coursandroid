package com.example.mod8tp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.mod8tp.databinding.ActivityMainBinding
import com.example.mod8tp.databinding.FragmentWeatherBinding

class WeatherFragment : Fragment() {

    lateinit var viewModel : CityViewModel
    lateinit var binding: FragmentWeatherBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentWeatherBinding>(
            inflater,
            R.layout.fragment_weather,
            container, false
        )
        binding.textViewTemperature.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.actionWeatherFragmentToCityFragment))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[CityViewModel::class.java]
        binding.vm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.buttonLyon.setOnClickListener{
            viewModel.getTemp(viewModel.listCity.get("Lyon")!!)
        }
        binding.buttonLille.setOnClickListener{
            viewModel.getTemp(viewModel.listCity.get("Lille")!!)
        }
        binding.buttonMarseille.setOnClickListener{
            viewModel.getTemp(viewModel.listCity.get("Marseille")!!)
        }
        binding.buttonNiort.setOnClickListener{
            viewModel.getTemp(viewModel.listCity.get("Niort")!!)
        }
        binding.buttonNantes.setOnClickListener{
            viewModel.getTemp(viewModel.listCity.get("Nantes")!!)
        }
        binding.buttonRennes.setOnClickListener{
            viewModel.getTemp(viewModel.listCity.get("Rennes")!!)
        }
        binding.textViewTemperature.setOnClickListener{
            viewModel.city.value?.let { city ->
                val direction = WeatherFragmentDirections.actionWeatherFragmentToCityFragment(city)
                Navigation.findNavController(it).navigate(direction)
            }
        }
    }
}
