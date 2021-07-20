package com.example.xcriticalapp.viewModel

import androidx.lifecycle.ViewModel
import com.example.xcriticalapp.adapter.CardItem
import com.example.xcriticalapp.useCase.MyDealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val myDealsUseCase: MyDealsUseCase) :ViewModel() {

    fun getList():ArrayList<CardItem> {
        return myDealsUseCase.getListFromRepo()
    }

}