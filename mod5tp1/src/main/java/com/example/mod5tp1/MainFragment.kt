package com.example.mod5tp1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.buttonRandom)
        button.setOnClickListener{
            val num = (1..2).random()
            if (num == 1){
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_redFragment)
            }
            else{
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_pinkFragment)
            }

        }
    }

}