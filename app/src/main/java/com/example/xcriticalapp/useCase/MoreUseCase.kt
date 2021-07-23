package com.example.xcriticalapp.useCase

import androidx.lifecycle.ViewModel
import com.example.xcriticalapp.repository.MyDetailDealsRepository
import javax.inject.Inject

class MoreUseCase @Inject constructor(private val myDetailDealsRepository: MyDetailDealsRepository):
    ViewModel(){
        suspend fun getMovie(){
            return myDetailDealsRepository.getMovies()
        }
}