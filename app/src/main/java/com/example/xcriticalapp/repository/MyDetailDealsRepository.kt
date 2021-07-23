package com.example.xcriticalapp.repository

import com.example.xcriticalapp.adapter.CardItem
import com.example.xcriticalapp.localApi.MyDetailDealsLocalApi
import com.example.xcriticalapp.model.Movie
import com.example.xcriticalapp.retrofit.RetrofitServices
import javax.inject.Inject


class MyDetailDealsRepository @Inject constructor(
    private val myDetailDealsLocalApi: MyDetailDealsLocalApi,
    private val retrofitServices: RetrofitServices
    ){
    private var listMovies : List<Movie>? = null

    suspend fun getMovies()
    {
        listMovies = retrofitServices.getMovieList().body()
        myDetailDealsLocalApi.getMovieList(listMovies)
    }

    fun getListFromApi(): ArrayList<CardItem> {
        return myDetailDealsLocalApi.generateList()
    }

    fun getIdFromApi(id:Int):CardItem {
        return myDetailDealsLocalApi.getModelById(id)
    }

}