package com.example.xcriticalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View;
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private val email by lazy {findViewById<EditText>(R.id.email_editText)}
    private val password by lazy {findViewById<EditText>(R.id.password_editText)}
    private val wrongEmail by lazy {findViewById<TextView>(R.id.wrong_email_textView)}
    private val wrongPassword by lazy {findViewById<TextView>(R.id.wrong_password_TextView)}
    private val forgotPassword by lazy {findViewById<TextView>(R.id.forgot_password_textView)}
    private val signInButton by lazy {findViewById<TextView>(R.id.sign_in_button)}
    private val registrationButton by lazy {findViewById<TextView>(R.id.register_button)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListeners()

    }

    private fun initListeners() {

        forgotPassword.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
         }

        signInButton.setOnClickListener {
            if(email.text.toString().isNullOrEmpty())
            {
                wrongEmail.visibility=View.VISIBLE
            }
            if(password.text.toString().isNullOrEmpty())
            {
                wrongPassword.visibility=View.VISIBLE
            }
        }

        registrationButton.setOnClickListener {
            if(email.text.toString().isNullOrEmpty())
            {
                wrongEmail.visibility=View.VISIBLE
            }
            if(password.text.toString().isNullOrEmpty())
            {
                wrongPassword.visibility=View.VISIBLE
            }
            else{
                val intent = Intent(this, RegistrationActivity::class.java)
                startActivity(intent)
            }
        }

        email.addTextChangedListener(object:TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                wrongEmail.visibility=View.INVISIBLE
            }
        })

        password.addTextChangedListener(object:TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                wrongPassword.visibility=View.INVISIBLE
            }
        })
    }

}