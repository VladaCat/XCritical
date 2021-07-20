package com.example.xcriticalapp.useCase

import com.example.xcriticalapp.adapter.CardItem
import com.example.xcriticalapp.repository.MyDetailDealsRepository
import javax.inject.Inject


class MyDetailDealsUseCase @Inject constructor(private val myDetailDealsRepository: MyDetailDealsRepository){

    fun getIdFromRepo(id:Int):CardItem{
        return myDetailDealsRepository.getIdFromApi(id)
    }

}