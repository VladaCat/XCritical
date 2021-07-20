package com.example.xcriticalapp.repository

import com.example.xcriticalapp.adapter.CardItem
import com.example.xcriticalapp.localApi.MyDetailDealsLocalApi
import javax.inject.Inject


class MyDetailDealsRepository @Inject constructor(private val myDetailDealsLocalApi: MyDetailDealsLocalApi){

    fun getListFromApi(): ArrayList<CardItem> {
        return myDetailDealsLocalApi.generateList()
    }

    fun getIdFromApi(id:Int):CardItem {
        return myDetailDealsLocalApi.getModelById(id)
    }

}