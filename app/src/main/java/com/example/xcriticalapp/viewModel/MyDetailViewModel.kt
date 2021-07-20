package com.example.xcriticalapp.viewModel

import androidx.lifecycle.ViewModel
import com.example.xcriticalapp.adapter.CardItem
import com.example.xcriticalapp.useCase.MyDetailDealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyDetailViewModel @Inject constructor(private val myDetailDealsUseCase: MyDetailDealsUseCase):ViewModel(){

    fun getId(id:Int): CardItem {
        return myDetailDealsUseCase.getIdFromRepo(id)
    }
}