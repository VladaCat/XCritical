package com.example.xcriticalapp

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.regex.Pattern

class MainViewModel:ViewModel() {

    var emailadress = ""
    var viewpassword = ""

    private val emailAddressPattern = Pattern.compile(
        "(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])"
    )
//    init{
//        validationEmail("ok")
//    }
    fun validationEmail():Boolean{
        return emailadress.isNullOrEmpty()||!emailAddressPattern.matcher(emailadress).matches()
    }

    fun validationPassword():Boolean{
        return viewpassword.isNullOrEmpty()
    }

//            if(password.text.isNullOrEmpty())
//            {
//                wrongPassword.visibility= View.VISIBLE
//            }
//            if(email.text.isNullOrEmpty()||!validationEmail(email.text.toString()))
//            {
//                wrongEmail.visibility= View.VISIBLE
//            }
//            else if(!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches())
//            {
//                wrongEmail.visibility=View.VISIBLE
//            }


}