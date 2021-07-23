package com.example.xcriticalapp.viewModel

import androidx.lifecycle.ViewModel
import com.example.xcriticalapp.adapter.CardItem
import com.example.xcriticalapp.adapter.CardItemWithImage
import com.example.xcriticalapp.useCase.MyDealsUseCase
import com.example.xcriticalapp.useCase.PresentationMyDealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val presentationMyDealsUseCase: PresentationMyDealsUseCase) :ViewModel() {

    fun getList():ArrayList<CardItemWithImage> {
        return presentationMyDealsUseCase.getList()
    }

}