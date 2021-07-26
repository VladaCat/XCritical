package com.example.xcriticalapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.xcriticalapp.R
import com.example.xcriticalapp.model.Movie
import com.squareup.picasso.Picasso

class MovieAdapter (private val movieList : List<Movie>?) : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imageMovie : ImageView = itemView.findViewById(R.id.image_movie)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.view_movie_card,parent,false)
        return MovieAdapter.MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        Picasso.get().load(movieList?.get(position)?.imageurl).into(holder.imageMovie)
    }

    override fun getItemCount(): Int = movieList!!.size

}