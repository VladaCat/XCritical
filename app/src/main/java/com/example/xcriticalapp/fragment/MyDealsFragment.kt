package com.example.xcriticalapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.xcriticalapp.R

class MyDealsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_deals, container, false)
        //val exampleList = generateDummyList(15)

//        val rv by lazy { findViewById<RecyclerView>(R.id.recycler_view) }
//            rv.adapter = Adapter(exampleList)
//            rv.layoutManager = LinearLayoutManager(this)
//            rv.setHasFixedSize(true)
    }

//    private fun generateDummyList(size: Int): List<ExampleItem> {
//        val list = ArrayList<ExampleItem>()
//        for (i in 0 until size) {
//           //val item = ExampleItem("", "","","","","","","")
//           //list += item
//        }
//        return list
//    }
}