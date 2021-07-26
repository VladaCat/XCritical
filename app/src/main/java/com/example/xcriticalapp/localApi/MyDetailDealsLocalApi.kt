package com.example.xcriticalapp.localApi

import com.example.xcriticalapp.adapter.CardItem
import com.example.xcriticalapp.model.Movie
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyDetailDealsLocalApi @Inject constructor() {

    private var list = ArrayList<CardItem>()
    private var movieList:List<Movie>? = null
    fun createMovieList(list: List<Movie>?){
        movieList =list
    }

    fun getMovieList():List<Movie>?{
        return movieList
    }
    fun generateList(): ArrayList<CardItem> {
        if(list.isNullOrEmpty())
        {
            createList()
        }
        return list
    }
    fun getModelById(id:Int):CardItem{
        return list.filter { it.id == id }[0]
    }

    private fun createList()
    {
        for (i in 0 until 20) {
            val item = CardItem( i ,"BATUSD", "CocaCola", "73,2391","/","73,5678","0,31%")
            list += item
        }
    }

}