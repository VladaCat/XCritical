package com.example.xcriticalapp

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.xcriticalapp.adapter.CustomAdapter
import javax.inject.Inject

class SwipeToDelete @Inject constructor(private val customAdapter:CustomAdapter):ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        var position : Int = viewHolder.adapterPosition
        customAdapter.deleteItem(position)
    }
}