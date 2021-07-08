package com.example.xcriticalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView

class RegistrationActivity : AppCompatActivity() {
    private val firstName by lazy {findViewById<EditText>(R.id.add_first_name_plainView)}
    private val secondName by lazy {findViewById<EditText>(R.id.add_second_name_plainView)}
    private val firstRequiredFields by lazy {findViewById<EditText>(R.id.required_field_textView)}
    private val secondRequiredFields by lazy {findViewById<EditText>(R.id.required_second_field_textView)}
    private val emailReg by lazy {findViewById<EditText>(R.id.registration_email_editText)}
    private val wrongRegEmail by lazy {findViewById<EditText>(R.id.wrong_email_textView)}
    private val phoneReg by lazy {findViewById<EditText>(R.id.registration_editTextPhone)}
    private val wrongRegPhone by lazy {findViewById<EditText>(R.id.incorrect_phone_number_textView)}
    private val newRegistrationButton by lazy {findViewById<TextView>(R.id.new_registration_button)}
    private val termsOfUseCheckBox by lazy{findViewById<TextView>(R.id.terns_of_use_checkBox)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        initRegistrationListeners()
    }

    private fun initRegistrationListeners() {
        newRegistrationButton.setOnClickListener {
            if(firstName.text.toString().isNullOrEmpty())
            {
                firstRequiredFields.visibility= View.VISIBLE
            }
            else if(secondName.text.toString().isNullOrEmpty())
            {
                secondRequiredFields.visibility= View.VISIBLE
            }
            else if(emailReg.text.toString().isNullOrEmpty())
            {
                wrongRegEmail.visibility= View.VISIBLE
            }
            else if(phoneReg.text.toString().isNullOrEmpty())
            {
                wrongRegPhone.visibility= View.VISIBLE
            }
            else{
                val successIntent = Intent(this, SuccessRegistrationActivity::class.java)
                startActivity(successIntent)
            }
        }

        firstName.addTextChangedListener(object: TextWatcher {
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
                firstRequiredFields.visibility=View.INVISIBLE
            }
        })

        secondName.addTextChangedListener(object: TextWatcher {
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
                secondRequiredFields.visibility=View.INVISIBLE
            }
        })

        emailReg.addTextChangedListener(object: TextWatcher {
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
                wrongRegEmail.visibility=View.INVISIBLE
            }
        })

        phoneReg.addTextChangedListener(object: TextWatcher {
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
                wrongRegPhone.visibility=View.INVISIBLE
            }
        })
    }
}