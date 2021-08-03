package com.example.xcriticalapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.xcriticalapp.CountryNumbers
import com.example.xcriticalapp.R
import com.example.xcriticalapp.adapter.CustomSpinnerAdapter
import com.example.xcriticalapp.databinding.ActivityRegistrationBinding
import com.example.xcriticalapp.viewModel.LoginViewModel
import com.example.xcriticalapp.viewModel.ViewModelRegistration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationActivity : AppCompatActivity() {
//    private val firstName by lazy {findViewById<EditText>(R.id.add_first_name_plainView)}
//    private val secondName by lazy {findViewById<EditText>(R.id.add_second_name_plainView)}
//    private val firstRequiredFields by lazy {findViewById<EditText>(R.id.required_field_textView)}
//    private val secondRequiredFields by lazy {findViewById<EditText>(R.id.required_second_field_textView)}
//    private val emailReg by lazy {findViewById<EditText>(R.id.registration_email_editText)}
//    private val wrongRegEmail by lazy {findViewById<EditText>(R.id.wrong_email_textView)}
//    private val phoneReg by lazy {findViewById<EditText>(R.id.registration_editTextPhone)}
//    private val wrongRegPhone by lazy {findViewById<EditText>(R.id.incorrect_phone_number_textView)}
//    private val newRegistrationButton by lazy {findViewById<TextView>(R.id.new_registration_button)}
//    private val termsOfUseCheckBox by lazy{findViewById<TextView>(R.id.terns_of_use_checkBox)}

//    lateinit var option : Spinner
//    lateinit var phone : EditText

    private lateinit var binding:ActivityRegistrationBinding
    private val viewModel by lazy { ViewModelProvider(this).get(ViewModelRegistration::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_registration)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        initRegistration()
        setSpinner()

//        setContentView(R.layout.activity_registration)
//
//        option = findViewById(R.id.spinner)
//        phone = findViewById(R.id.registration_editTextPhone)
//
//        val options = arrayOf("Ukraine(+380)","Russia(+7)","Australia(+63)")
//
//        option.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
//        option.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//               // phone.text = "Phone"
//            }
//
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                phone.setText(options.get(position))
//            }
//        }

    }

    private fun initRegistration() {
        viewModel.registration.observe(this) {
            if (it) {
                val intent = Intent(this, MainScreen::class.java)
                startActivity(intent)
            }
        }
    }

    private fun setSpinner() {
        val adapter = CustomSpinnerAdapter(this, CountryNumbers.Countries.list)
        binding.spinner.adapter = adapter
    }

}