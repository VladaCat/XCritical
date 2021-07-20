package com.example.xcriticalapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.xcriticalapp.R
import com.example.xcriticalapp.viewModel.MyDetailViewModel
import com.example.xcriticalapp.viewModel.MyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyDetailDealsFragment : Fragment() {

    private val viewModel by lazy { ViewModelProvider(this).get(MyDetailViewModel::class.java)}
    private val companyText by lazy {view?.findViewById<TextView>(R.id.company_textView)}
    private val hintText by lazy {view?.findViewById<TextView>(R.id.hint_textView)}
    private val firstNumberText by lazy {view?.findViewById<TextView>(R.id.firstnbr_textView)}
    private val secondNumberText by lazy {view?.findViewById<TextView>(R.id.secondnbr_textView)}
    private val delimiterText by lazy {view?.findViewById<TextView>(R.id.delim_textView)}
    private val percentText by lazy {view?.findViewById<TextView>(R.id.perc_textView)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_detail_deals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val itemClicked:Int = arguments?.getInt("id")!!
        init(itemClicked)
    }

    private fun init(id:Int)
    {
        val model = viewModel.getId(id)

        companyText?.text = model.companyText
        hintText?.text = model.productText
        firstNumberText?.text = model.firstNumberText
        secondNumberText?.text = model.secondNumberText
        delimiterText?.text = model.delimiterText
        percentText?.text = model.percentText

    }

}