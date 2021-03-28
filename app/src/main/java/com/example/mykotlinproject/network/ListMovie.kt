package com.example.mykotlinproject.network

import com.google.gson.annotations.SerializedName


/** Data class for Retrofit request from ListActivity */
data class Results(
    @SerializedName("results") val networkMovie: List<ListMovie>,
    val page: Int,
    val total_results: Int,
    val total_pages: Int
)

data class ListMovie(
    val id: Int,
    var adult: Boolean,
    var popularity: Double,
    var voteCount: Int,
    val video: Boolean,
    val poster_path: String,
    val backdrop_path: String,
    val original_language: String,
    val original_title: String,
    val genre_ids: List<Int>,
    val title: String,
    val vote_average: Double,
    val overview: String,
    val release_date: String
)