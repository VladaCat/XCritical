package com.example.xcriticalapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.xcriticalapp.CountryNumbers
import com.example.xcriticalapp.R

class CustomSpinnerAdapter(context: Context, listCountriesNumbers: List<CountryNumbers>)
    : ArrayAdapter<CountryNumbers>(context, 0, listCountriesNumbers) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            return init(position, convertView, parent)
        }

        override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
            return init(position, convertView, parent)
        }

        private fun init(position: Int, convertView: View?, parent: ViewGroup): View {
            val countriesNumbers = getItem(position)

            val view = LayoutInflater.from(context).inflate(R.layout.spinner_item, parent, false)
            val imageCountry : ImageView = view.findViewById(R.id.imageCountry)
            val country: TextView = view.findViewById(R.id.countyName)
            val number: TextView = view.findViewById(R.id.numberCountry)

            imageCountry.setImageResource(countriesNumbers!!.image)
            country.text =  countriesNumbers.country
            number.text =  countriesNumbers.number

            return view
        }
}