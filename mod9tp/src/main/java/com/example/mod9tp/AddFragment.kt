package com.example.mod9tp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.mod9tp.databinding.FragmentAddBinding


class AddFragment : Fragment() {
    lateinit var binding : FragmentAddBinding
    val vm : AddQualiteAirVM by viewModels { AddQualiteAirVM.Factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAdd.setOnClickListener{
            val qualiteAir = QualiteAir(
                0L,
                binding.editTextLieu.text.toString(),
                binding.ratingBarNote.rating
            )
            vm.addQualiteAir(qualiteAir)
        }
        binding.buttonShow.setOnClickListener{
            val direction = AddFragmentDirections.actionAddFragmentToShowFragment()
            Navigation.findNavController(view).navigate(direction)
        }
    }



}