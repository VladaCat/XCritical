package com.example.xcriticalapp.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Movie (
    var name: String? = null,
    var realname: String? = null,
    var team: String? = null,
    var firstapperance: String? = null,
    var createdby: String? = null,
    var publisher: String? = null,
    var imageurl: String? = null,
    var bio: String? = null
){
}