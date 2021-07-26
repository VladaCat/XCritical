package com.example.xcriticalapp.useCase

import androidx.lifecycle.ViewModel
import com.example.xcriticalapp.model.Movie
import com.example.xcriticalapp.repository.MyDetailDealsRepository
import javax.inject.Inject

class MoreUseCase @Inject constructor(private val myDetailDealsRepository: MyDetailDealsRepository):
    ViewModel(){
        suspend fun createMovie(){
            return myDetailDealsRepository.createMovies()
        }
    fun getMovieList(): List<Movie>? {
        return myDetailDealsRepository.getMovies()
    }
}