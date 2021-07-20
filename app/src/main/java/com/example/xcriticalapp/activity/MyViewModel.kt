package com.example.xcriticalapp.activity

import androidx.lifecycle.ViewModel
import com.example.xcriticalapp.adapter.ExampleItem
import com.example.xcriticalapp.useCase.MyDetailDealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val myDetailDealsUseCase: MyDetailDealsUseCase) :ViewModel() {

    fun getList():ArrayList<ExampleItem>
    {
        return myDetailDealsUseCase.generateList()
    }

}