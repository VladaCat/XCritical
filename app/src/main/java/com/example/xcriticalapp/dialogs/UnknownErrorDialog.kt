package com.example.xcriticalapp.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.xcriticalapp.R

public class UnknownErrorDialog : DialogFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView:View = inflater.inflate(R.layout.fragment_error_login, container, false)
        rootView.findViewById<TextView>(R.id.unknown_error_Button).setOnClickListener{
            dismiss()
        }
        return rootView
    }
}