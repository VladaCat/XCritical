package com.example.xcriticalapp.viewModel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class ViewModelRegistration @Inject constructor() : ViewModel(){

    var name = MutableLiveData<String>().apply { value = "Vlada" }
    var lastName = MutableLiveData<String>().apply { value = "Vlada" }
    var number = MutableLiveData<String>().apply { value = "0500543134" }
    var email = MutableLiveData<String>().apply { value = "vd@gmail.com" }

    private val _validName = MutableLiveData<Boolean>().apply { value = true }
    val validName: LiveData<Boolean>
        get() = _validName

    private val _validLastName = MutableLiveData<Boolean>().apply { value = true }
    val validLastName: LiveData<Boolean>
        get() = _validLastName

    private val _validNumber = MutableLiveData<Boolean>().apply { value = true }
    val validNumber: LiveData<Boolean>
        get() = _validNumber

    private val _validEmail = MutableLiveData<Boolean>().apply { value = true }
    val validEmail: LiveData<Boolean>
        get() = _validEmail

    private val _registration = MutableLiveData<Boolean>()
    val registration: LiveData<Boolean>
        get() = _registration

    fun onRegistration() {
        _validName.value = !name.value.isNullOrEmpty()
        _validLastName.value = !lastName.value.isNullOrEmpty()
        _validNumber.value = !number.value.isNullOrEmpty()
        _validEmail.value = !email.value.isNullOrEmpty() || Patterns.EMAIL_ADDRESS.matcher(email.toString()).matches()
        _registration.value = !(name.value.isNullOrEmpty() || lastName.value.isNullOrEmpty() || number.value.isNullOrEmpty() || email.value.isNullOrEmpty())
    }
}