package com.example.mod9tp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels

class ShowFragment : Fragment() {


    val vm : ShowQualiteAirVM by viewModels { ShowQualiteAirVM.Factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView : TextView = view.findViewById(R.id.textViewShow)
        vm.fetchQualiteAir()
        vm.lsQualiteAir.observe(viewLifecycleOwner){ lsQualiteAir ->
            var text = ""
            lsQualiteAir.forEach { text += it.toString() + "\n" }
            textView.text = text

        }
    }

}