package com.example.xcriticalapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    private val viewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_deals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val recyclerView = getView()?.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView?.layoutManager = LinearLayoutManager(this.context)
        recyclerView?.adapter = Adapter(viewModel.getList()) {id->itemClicked(id)}

    }

    private fun itemClicked(id:Int) {
        val bundle = bundleOf("id" to id)
        view?.findNavController()?.navigate(R.id.action_myDealsFragment_to_myDetailDealsFragment4,bundle)
    }


}