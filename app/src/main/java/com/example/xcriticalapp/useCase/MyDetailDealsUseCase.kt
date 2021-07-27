package com.example.xcriticalapp.useCase

import com.example.xcriticalapp.adapter.CardItem
import com.example.xcriticalapp.repository.Repository
import javax.inject.Inject


class MyDetailDealsUseCase @Inject constructor(private val repository: Repository){

    fun getIdFromRepo(id:Int):CardItem{
        return repository.getIdFromApi(id)
    }

}