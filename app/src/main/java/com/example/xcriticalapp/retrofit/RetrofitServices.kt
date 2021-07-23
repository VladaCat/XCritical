package com.example.xcriticalapp.retrofit
import com.example.xcriticalapp.model.Movie
import retrofit2.Response
import retrofit2.http.*

interface RetrofitServices {
    @GET("marvel")
   suspend fun getMovieList(): Response<List<Movie>>
}