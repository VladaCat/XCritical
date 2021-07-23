package com.example.xcriticalapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.xcriticalapp.repository.MyDetailDealsRepository
import com.example.xcriticalapp.useCase.MoreUseCase
import javax.inject.Inject
import kotlinx.coroutines.launch
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class MoreViewModel @Inject constructor(private val moreUseCase: MoreUseCase):ViewModel() {
    fun getMovie(){

        viewModelScope.launch{
            moreUseCase.getMovie()
        }
    }
}