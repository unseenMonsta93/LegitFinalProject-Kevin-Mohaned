package datanapps.retrofitkotlin.view.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import datanapps.retrofitkotlin.R
import kotlinx.android.synthetic.main.fragment_blank.*

class StartFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(
                R.layout.fragment_blank, container, false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        buttonViewCredits.setOnClickListener {
           findNavController().navigate(R.id.action_startFragment_to_blankFragment)




        }
    }
}
