package com.example.xcriticalapp.repository

import com.example.xcriticalapp.adapter.CardItem
import com.example.xcriticalapp.localApi.LocalApi
import com.example.xcriticalapp.model.Movie
import com.example.xcriticalapp.retrofit.RetrofitServices
import javax.inject.Inject


class Repository @Inject constructor(
    private val localApi: LocalApi,
    private val retrofitServices: RetrofitServices
    ){
    private var listMovies : List<Movie>? = null

    suspend fun createMovies()
    {
        listMovies = retrofitServices.getMovieList().body()
        localApi.createMovieList(listMovies)
    }

    fun getMovies(): List<Movie>? {
        return localApi.getMovieList()
    }
    fun getListFromApi(): ArrayList<CardItem> {
        return localApi.generateList()
    }

    fun getIdFromApi(id:Int):CardItem {
        return localApi.getModelById(id)
    }

}