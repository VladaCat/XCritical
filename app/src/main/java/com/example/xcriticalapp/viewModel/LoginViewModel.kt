package com.example.xcriticalapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.xcriticalapp.SharedPreferenceExample
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(var sharedPreferenceExample: SharedPreferenceExample): ViewModel(){

    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()

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

    fun saveLoginAndPassword(){
        sharedPreferenceExample.addProperty("email", email.value.toString())
        sharedPreferenceExample.addProperty("password",password.value.toString())
    }
    fun getLoginAndPassword(){
        email.value = sharedPreferenceExample.getProperty("email")
        password.value = sharedPreferenceExample.getProperty("password")
    }

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

}