package com.example.xcriticalapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel(){

    var email = MutableLiveData<String>().apply { value = "alpha@g.com" }
    var password = MutableLiveData<String>().apply { value = "qwerty12345" }

    private val _isValidEmail = MutableLiveData<Boolean>().apply { value=true }
    val isValidEmail:LiveData<Boolean>
        get()=_isValidEmail

    private val _isValidPassword = MutableLiveData<Boolean>().apply { value=true }
    val isValidPassword:LiveData<Boolean>
        get()=_isValidPassword

    private val _isLoginSuccess = MutableLiveData<Boolean>()
    val isLoginSuccess:LiveData<Boolean>
        get()=_isLoginSuccess

    private val emailAddressPattern = Pattern.compile(
        "(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])"
    )

//    fun login(){
//        _isValidEmail.value = !email.value.isNullOrEmpty()
//        _isValidPassword.value = !password.value.isNullOrEmpty()
//        if(email.value.isNullOrEmpty()||password.value.isNullOrEmpty()||!emailAddressPattern.matcher(email.toString()).matches())
//        {
//            return
//        }
//    }

    fun onEmailTextChanged(s: CharSequence, start : Int,before : Int, count : Int){
        _isValidEmail.value = true
    }


    fun onPasswordTextChanged(s: CharSequence, start : Int,before : Int, count : Int){
        _isValidPassword.value = true
    }

    fun login(email : String, password : String){

        _isValidEmail.value = emailAddressPattern.matcher(email).matches()

        _isValidEmail.value = !email.isNullOrEmpty() //&& emailAddressPattern.matcher(email).matches() надо починить регулярку

        _isValidPassword.value = !password.isNullOrEmpty()

        _isLoginSuccess.value = (_isValidPassword.value!! && _isValidEmail.value!!)
    }

//    fun validationEmail():Boolean{
//        return email.isNullOrEmpty()||!emailAddressPattern.matcher(emailadress).matches()
//        //return true
//    }
//
//    fun validationPassword():Boolean{
//        return password.isNullOrEmpty()
//        //return true
//    }
}