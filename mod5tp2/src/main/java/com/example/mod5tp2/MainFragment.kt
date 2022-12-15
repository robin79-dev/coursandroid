package com.example.mod5tp2

import android.graphics.Path.Direction
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.findNavController

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
        val button = view.findViewById<Button>(R.id.buttonStory)
        val textPrenom = view.findViewById<EditText>(R.id.editTextPrenom)
        val textLieu = view.findViewById<EditText>(R.id.editTextLieu)

        button.setOnClickListener{
            val direction: NavDirections = MainFragmentDirections.actionMainFragmentToSecondFragment(
                Histoire(textPrenom.text.toString(), textLieu.text.toString())
            )
            Navigation.findNavController(view).navigate(direction)
        }

    }

}