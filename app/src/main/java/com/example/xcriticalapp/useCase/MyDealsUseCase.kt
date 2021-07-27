package com.example.xcriticalapp.useCase

import com.example.xcriticalapp.adapter.CardItem
import com.example.xcriticalapp.repository.Repository
import javax.inject.Inject

class MyDealsUseCase @Inject constructor(private val repository: Repository){

    fun getListFromRepo(): ArrayList<CardItem> {
        return repository.getListFromApi()
    }

    fun filterList(){
        
    }
}