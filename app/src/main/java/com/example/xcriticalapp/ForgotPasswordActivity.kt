package com.example.xcriticalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.util.regex.Pattern

class ForgotPasswordActivity : AppCompatActivity() {
    private val forgotEmail by lazy {findViewById<EditText>(R.id.forgot_password_email_editText)}
    private val wrongForgotEmail by lazy {findViewById<TextView>(R.id.forgot_password_wrong_email_textView)}
    private val nextForgotButton by lazy {findViewById<TextView>(R.id.forgot_password_next_button)}
    private val backForgotButton by lazy {findViewById<TextView>(R.id.forgot_password_back_button)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        initForgotPassListeners()
    }

    private val emailAddressForgotPattern = Pattern.compile(
        "(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"
    )
    private fun validationForgotEmail(email: String) = emailAddressForgotPattern.matcher(email).matches()

    private fun initForgotPassListeners() {

        nextForgotButton.setOnClickListener {

            if(forgotEmail.text.isNullOrEmpty()||!validationForgotEmail(forgotEmail.text.toString()))
            {
                wrongForgotEmail.visibility= View.VISIBLE
            }

        }

        forgotEmail.addTextChangedListener(object: TextWatcher {
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
                wrongForgotEmail.visibility=View.INVISIBLE
            }
        })

        backForgotButton.setOnClickListener {
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)}


    }
}