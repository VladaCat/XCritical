package com.example.xcriticalapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.xcriticalapp.R

class SuccessRegistrationActivity : AppCompatActivity() {
    private val successNextButton by lazy {findViewById<TextView>(R.id.success_registration_next_button)}
    private val successPinButton by lazy {findViewById<TextView>(R.id.success_registration_pin_button)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_registration)

        initSuccessListeners()
    }

    private fun initSuccessListeners() {
        successNextButton.setOnClickListener {
            val mainIntent = Intent(this, LoginActivity::class.java)
            startActivity(mainIntent)
        }
        successPinButton.setOnClickListener {
            val mainIntent = Intent(this, LoginActivity::class.java)
            startActivity(mainIntent)
        }
    }

}