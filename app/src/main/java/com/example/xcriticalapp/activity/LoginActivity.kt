package com.example.xcriticalapp.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.xcriticalapp.R
import com.example.xcriticalapp.databinding.ActivityLoginBinding
import com.example.xcriticalapp.viewModel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.regex.Pattern

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val email by lazy {findViewById<EditText>(R.id.email_editText)}
    private val password by lazy {findViewById<EditText>(R.id.password_editText)}
    private val wrongEmail by lazy {findViewById<TextView>(R.id.wrong_email_textView)}
    private val wrongPassword by lazy {findViewById<TextView>(R.id.wrong_password_TextView)}
    private val forgotPassword by lazy {findViewById<TextView>(R.id.forgot_password_textView)}
    private val signInButton by lazy {findViewById<TextView>(R.id.sign_in_button)}
    private val registrationButton by lazy {findViewById<TextView>(R.id.register_button)}
    private val errorEmail by lazy {findViewById<TextView>(R.id.wrong_email_textView)}

    //BINDING
    private lateinit var binding : ActivityLoginBinding
    private val viewModel by lazy { ViewModelProvider(this).get(LoginViewModel::class.java) }

    private val emailAddressPattern = Pattern.compile(
        "(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        binding.lifecycleOwner=this
        binding.viewModel = viewModel

        initObserve()
        //initListeners()
        Log.d("activityLiveCycleTest","onCreate")
    }

    override fun onPause(){
        super.onPause()
        Log.w("activityLiveCycleTest2","onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d("activityLiveCycleTest","onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("activityLiveCycleTest2","onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("activityLiveCycleTest","onDestroy")
    }

    override fun onStop() {
        super.onStop()
        Log.i("activityLiveCycleTest","onStop")
    }
    override fun onStart() {
        super.onStart()
        Log.d("activityLiveCycleTest2","onStart")
    }

    private fun initObserve(){

        viewModel.isLoginSuccess.observe(this){
            if(it){
                val mainScreenIntent = Intent(this, MainScreen::class.java)
                startActivity(mainScreenIntent)
                finish()
            }
            else
            {

            }
        }
    }

    private  fun isValidEmail(target: EditText) = emailAddressPattern.matcher(target.text.toString()).matches()
    private fun listener(){
        email.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                wrongEmail.isVisible = false
            }

        })

        password.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                wrongPassword.isVisible = false
            }

        })

//    private fun initListeners() {
//
//        viewModel.emailadress = email.text.toString()
//        viewModel.viewpassword = password.text.toString()
//        forgotPassword.setOnClickListener {
//            val forgotPasswordIntent = Intent(this, ForgotPasswordActivity::class.java)
//            startActivity(forgotPasswordIntent)
//         }
//
//        signInButton.setOnClickListener {
//
//            if(!viewModel.validationEmail())
//            {
//                wrongEmail.visibility=View.VISIBLE
//            }
//            if(!viewModel.validationPassword())
//            {
//                wrongPassword.visibility=View.VISIBLE
//            }
//
//
//        }
//
//        registrationButton.setOnClickListener {
//                val registrationIntent = Intent(this, RegistrationActivity::class.java)
//                startActivity(registrationIntent)
//        }
//
//        email.addTextChangedListener(object:TextWatcher {
//            override fun afterTextChanged(s: Editable) {}
//
//            override fun beforeTextChanged(
//                s: CharSequence, start: Int,
//                count: Int, after: Int
//            ) {
//            }
//
//            override fun onTextChanged(
//                s: CharSequence, start: Int,
//                before: Int, count: Int
//            ) {
//                wrongEmail.visibility=View.INVISIBLE
//            }
//        })
//
//        password.addTextChangedListener(object:TextWatcher {
//            override fun afterTextChanged(s: Editable) {}
//
//            override fun beforeTextChanged(
//                s: CharSequence, start: Int,
//                count: Int, after: Int
//            ) {
//            }
//
//            override fun onTextChanged(
//                s: CharSequence, start: Int,
//                before: Int, count: Int
//            ) {
//                wrongPassword.visibility=View.INVISIBLE
//            }
//        })
//    }

}}