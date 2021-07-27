package com.example.xcriticalapp.useCase

import androidx.lifecycle.ViewModel
import com.example.xcriticalapp.model.Movie
import com.example.xcriticalapp.repository.Repository
import javax.inject.Inject

class MoreUseCase @Inject constructor(private val repository: Repository):
    ViewModel(){
        suspend fun createMovie(){
            return repository.createMovies()
        }
    fun getMovieList(): List<Movie>? {
        return repository.getMovies()
    }
}