package com.example.mod5nav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

class ButtonFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_button, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.button)

        button.setOnClickListener{
            //Navigation.findNavController(view).navigate(R.id.actionButtonToSecond)
            val direction: NavDirections =ButtonFragmentDirections.actionButtonToSecond(
                User("toto", "titi")
            )

            Navigation.findNavController(view).navigate(direction)
        }
    }
}