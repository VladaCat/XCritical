package com.example.xcriticalapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xcriticalapp.MyViewModel
import com.example.xcriticalapp.adapter.Adapter
import com.example.xcriticalapp.adapter.ExampleItem
import com.example.xcriticalapp.R

class MyDealsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_deals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val model: MyViewModel by viewModels()
        val recyclerView = getView()?.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView?.layoutManager = LinearLayoutManager(this.context)
        recyclerView?.adapter = Adapter(model.generateDummyList(15), { itemClicked() } )
    }

    private fun itemClicked() {
        //Toast.makeText(this.context, "Clicked", Toast.LENGTH_SHORT).show()

        val bundle = Bundle()
        val idCard = "Cat"
        bundle.putString(
            "Hello, ", idCard
        )
        view?.findNavController()?.navigate(R.id.action_myDealsFragment_to_accountFragment,bundle)
    }

}