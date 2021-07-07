package com.example.xcriticalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View;
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener

lateinit var sign_in_button:Button
lateinit var registration_button:Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val email by lazy {findViewById<EditText>(R.id.email_editText)}
        val password by lazy {findViewById<EditText>(R.id.password_editText)}
        val wrong_email by lazy {findViewById<TextView>(R.id.wrong_email_text)}
        val wrong_password by lazy {findViewById<TextView>(R.id.wrong_password_text)}
        val forgot_password by lazy {findViewById<TextView>(R.id.forgot_password_textView)}

        forgot_password.setOnClickListener{
        val intent = Intent(this, ForgotPasswordActivity::class.java)
        startActivity(intent)
        }

        sign_in_button = findViewById(R.id.sign_in_button)
        registration_button = findViewById(R.id.register_button)

        sign_in_button.setOnClickListener {
            if(email.text.toString().isEmpty())
            {
                wrong_email.visibility=View.VISIBLE
            }
            if(password.text.toString().isEmpty())
            {
                wrong_password.visibility=View.VISIBLE
            }
        }

        registration_button.setOnClickListener {
            if(email.text.toString().isEmpty())
            {
                wrong_email.visibility=View.VISIBLE
            }
            if(password.text.toString().isEmpty())
            {
                wrong_password.visibility=View.VISIBLE
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
                wrong_email.visibility=View.INVISIBLE
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
                wrong_password.visibility=View.INVISIBLE
            }
        })
    }

}