package com.example.xcriticalapp.fragment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.xcriticalapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyDetailDealsFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val av = view.findViewById<TextView>(R.id.hello_account)
        av?.text = arguments?.getString("id")
    }
}