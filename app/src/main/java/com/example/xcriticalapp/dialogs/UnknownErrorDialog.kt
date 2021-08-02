package com.example.xcriticalapp.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.xcriticalapp.R

public class UnknownErrorDialog constructor(private val func: () -> Unit): DialogFragment(){
    private val btn by lazy{view?.findViewById<Button>(R.id.register_button)}
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView:View = inflater.inflate(R.layout.fragment_error_login, container, false)
        rootView.findViewById<TextView>(R.id.unknown_error_Button).setOnClickListener{
                func()
                dismiss() }//имитация что-то происходит
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
//    fun clickButton(func:()->Unit){
//        func()
//        dismiss()
//    }
}