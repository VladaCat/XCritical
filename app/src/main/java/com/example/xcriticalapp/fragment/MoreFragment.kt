package com.example.xcriticalapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xcriticalapp.R
import com.example.xcriticalapp.adapter.Adapter
import com.example.xcriticalapp.adapter.MovieAdapter
import com.example.xcriticalapp.viewModel.MoreViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoreFragment : Fragment() {

    private val getMovieButton by lazy {view?.findViewById<Button>(R.id.getMovies_Button)}
    private val viewModel by lazy{ViewModelProvider(this).get(MoreViewModel::class.java)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.createMovie()
        getMovieButton?.setOnClickListener {
            val recyclerView = getView()?.findViewById<RecyclerView>(R.id.getMovie_RecyclerView)
            recyclerView?.layoutManager = LinearLayoutManager(this.context)
            recyclerView?.adapter = MovieAdapter(viewModel.getMovieList())
           // var movieList = viewModel.getMovieList()
        }

    }

}