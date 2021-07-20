package com.example.xcriticalapp.adapter

import com.example.xcriticalapp.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Singleton


class UseCase @Inject constructor(){
    fun generateList(): ArrayList<ExampleItem> {
        val list = ArrayList<ExampleItem>()
        for (i in 0 until 20) {
            val drawable = when (i % 2) {
                0 -> R.drawable.ic_recycle_icon
                else -> R.drawable.ic_star_3
            }
            val item = ExampleItem( i ,"BATUSD", "CocaCola", "73,2391","/","73,5678","0,31%")
            list += item
        }
        return list
    }
}