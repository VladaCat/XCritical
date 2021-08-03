package com.example.xcriticalapp

data class CountryNumbers(val image:Int,val country:String,val number:String) {

    object Countries {

        private val images = intArrayOf(
            R.drawable.ic_russia,
            R.drawable.ic_austria,
            R.drawable.ic_andora,
            R.drawable.ic_azerbaigan,
            R.drawable.ic_england,
        )

        private val countries = arrayOf(
            "Russia",
            "Австрия",
            "Андора",
            "Азербайджан",
            "Ангилия"
        )

        private val numbers = arrayOf(
            "+7",
            "(+43)",
            "(+3581)",
            "(+994)",
            "(+1264)"
        )

        var list = ArrayList<CountryNumbers>()
            get() {
                field = ArrayList()
                for (i in images.indices) {
                    val imageId = images[i]
                    val countryNames = countries[i]
                    val numbersInCountries = numbers[i]

                    val countriesNumbers = CountryNumbers(imageId, countryNames, numbersInCountries)
                    field.add(countriesNumbers)
                }
                return field
            }
    }
}