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
import com.example.xcriticalapp.dialogs.UnknownErrorDialog
import com.example.xcriticalapp.fragment.ErrorLoginFragment
import com.example.xcriticalapp.viewModel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.regex.Pattern

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

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
        viewModel.getLoginAndPassword()
        initObserve()
        binding.forgotPasswordTextView.setOnClickListener {
            var dialog = UnknownErrorDialog()
            dialog.show(supportFragmentManager,"unknownErrorDialog")
        }
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
                viewModel.saveLoginAndPassword()
                val mainScreenIntent = Intent(this, MainScreen::class.java)
                startActivity(mainScreenIntent)
                finish()
            }
            else
            {

            }
        }
    }

}