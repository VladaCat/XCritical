package com.example.xcriticalapp.useCase

import com.example.xcriticalapp.R
import com.example.xcriticalapp.adapter.ExampleItem
import javax.inject.Inject


class MyDetailDealsUseCase @Inject constructor(){
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