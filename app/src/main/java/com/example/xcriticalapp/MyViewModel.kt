package com.example.xcriticalapp

import androidx.lifecycle.ViewModel
import com.example.xcriticalapp.adapter.ExampleItem
import java.util.regex.Pattern

class MyViewModel:ViewModel() {

    var emailadress = ""
    var viewpassword = ""

    fun generateDummyList(size: Int): ArrayList<ExampleItem> {
        val list = ArrayList<ExampleItem>()
        for (i in 0 until size) {
            val drawable = when (i % 2) {
                0 -> R.drawable.ic_recycle_icon
                else -> R.drawable.ic_star
            }
            val item = ExampleItem("BATUSD" , "CocaCola", "73,2391","/","73,5678","0,31%")
            list += item
        }
        return list
    }

    private val emailAddressPattern = Pattern.compile(
        "(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])"
    )

    fun validationEmail():Boolean{
        return emailadress.isNullOrEmpty()||!emailAddressPattern.matcher(emailadress).matches()
    }

    fun validationPassword():Boolean{
        return viewpassword.isNullOrEmpty()
    }

}