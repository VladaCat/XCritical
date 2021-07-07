package com.example.xcriticalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View;
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val email by lazy {findViewById<EditText>(R.id.email_editText)}
        val password by lazy {findViewById<EditText>(R.id.password_editText)}
        val wrong_email by lazy {findViewById<TextView>(R.id.wrong_email_text)}
        val wrong_password by lazy {findViewById<TextView>(R.id.wrong_password_text)}
    }

}