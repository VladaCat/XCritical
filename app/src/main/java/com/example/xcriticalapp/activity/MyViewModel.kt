package com.example.xcriticalapp.activity

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.example.xcriticalapp.R
import com.example.xcriticalapp.adapter.ExampleItem
import com.example.xcriticalapp.adapter.UseCase
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val useCase: UseCase) :ViewModel() {

    fun getList():ArrayList<ExampleItem>
    {
        return useCase.generateList()
    }

}