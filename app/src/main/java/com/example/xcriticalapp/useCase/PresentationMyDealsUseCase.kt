package com.example.xcriticalapp.useCase

import com.example.xcriticalapp.R
import com.example.xcriticalapp.adapter.CardItem
import com.example.xcriticalapp.adapter.CardItemWithImage
import com.example.xcriticalapp.repository.Repository
import javax.inject.Inject

class PresentationMyDealsUseCase @Inject constructor(private val repository: Repository){

    private val listRepository:ArrayList<CardItem> = repository.getListFromApi()
    private val presentationList = ArrayList<CardItemWithImage>()
    fun getList(): ArrayList<CardItemWithImage> {

        generatePresentationList()
        return presentationList
    }
    private fun generatePresentationList()
    {
        for (i in 0.. listRepository.size-1){
            if(i%2==0){
                presentationList += CardItemWithImage(listRepository[i].id,
                    listRepository[i].companyText,
                    listRepository[i].productText,
                    listRepository[i].firstNumberText,
                    listRepository[i].delimiterText,
                    listRepository[i].secondNumberText,
                    listRepository[i].percentText,
                    R.drawable.ic_recycle_icon,
                    R.drawable.ic_star_3)
            }
            else{
                presentationList += CardItemWithImage(listRepository[i].id,
                    listRepository[i].companyText,
                    listRepository[i].productText,
                    listRepository[i].firstNumberText,
                    listRepository[i].delimiterText,
                    listRepository[i].secondNumberText,
                    listRepository[i].percentText,
                    R.drawable.ic_ellipse,
                    R.drawable.ic_star_3)
            }
        }
    }
}