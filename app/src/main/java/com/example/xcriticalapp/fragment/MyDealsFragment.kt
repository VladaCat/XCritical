package com.example.xcriticalapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xcriticalapp.activity.MyViewModel
import com.example.xcriticalapp.adapter.Adapter
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
        recyclerView?.adapter = Adapter(model.generateDummyList(15)) { id -> itemClicked(id)}
    }

    private fun itemClicked(id:Int) {
        //Toast.makeText(this.context, "Clicked", Toast.LENGTH_SHORT).show()
        val bundle = bundleOf("id" to "Card id $id")
        view?.findNavController()?.navigate(R.id.action_myDealsFragment_to_accountFragment,bundle)
    }

}