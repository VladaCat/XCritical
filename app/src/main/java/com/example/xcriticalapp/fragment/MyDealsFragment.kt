package com.example.xcriticalapp.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xcriticalapp.viewModel.MyViewModel
import com.example.xcriticalapp.adapter.Adapter
import com.example.xcriticalapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyDealsFragment : Fragment() {

    private  val searchEditText by lazy{ view?.findViewById<EditText>(R.id.search_editText)}
    private val viewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java)}

    private var adapter : Adapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_deals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val recycler = getView()?.findViewById<RecyclerView>(R.id.recycler_view)
        recycler?.layoutManager = LinearLayoutManager(this.context)
        adapter =  Adapter(viewModel.getList()) { id -> itemClicked(id) }
        recycler?.adapter = adapter

        searchEditText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                adapter?.updateFilteredList(viewModel.getFilterList(s.toString()))
            }

        })
    }

    private fun itemClicked(id:Int) {
        val bundle = bundleOf("id" to id)
        view?.findNavController()?.navigate(R.id.action_myDealsFragment_to_myDetailDealsFragment4,bundle)
    }

}