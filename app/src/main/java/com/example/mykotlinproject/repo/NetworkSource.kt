package com.example.mykotlinproject.repo


import com.example.mykotlinproject.network.ListMovie
import com.example.mykotlinproject.network.MovieApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieListSource @Inject constructor(private val api: MovieApi) {
    suspend fun fetchMovieList(
        category: String, key: String, language: String, page: Int
    ): List<ListMovie> = withContext(Dispatchers.IO) {
        val playList = api.getPropertyAsync(category, key, language, page)
        playList.networkMovie
    }
}

//class SmallMovieListSource @Inject constructor(private val api: MovieApi) {
//    suspend fun fetchSmallMovieList(
//        category: String, key: String, language: String
//    ): List<SmallMovieList> = withContext(Dispatchers.IO) {
//        val playList = api.getListOfPosters(category, key, language)
//        playList.smallMovieList
//    }
//}

//class MovieDetailSource @Inject constructor(private val api: MovieApi) {
//    suspend fun fetchDetailInformationOfMovie(id: Int): MovieInfo = withContext(Dispatchers.IO) {
//        val infoOfMovie = api.getMovieByID(id)
//        infoOfMovie
//    }
//}