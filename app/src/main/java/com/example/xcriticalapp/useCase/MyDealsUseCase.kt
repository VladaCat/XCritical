package com.example.xcriticalapp.useCase

import com.example.xcriticalapp.adapter.CardItem
import com.example.xcriticalapp.repository.MyDetailDealsRepository
import javax.inject.Inject

class MyDealsUseCase @Inject constructor(private val myDetailDealsRepository: MyDetailDealsRepository){

    fun getListFromRepo(): ArrayList<CardItem> {
        return myDetailDealsRepository.getListFromApi()
    }
}