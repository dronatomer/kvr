package com.example.mykotlinproject.network


import com.example.mykotlinproject.utils.API_KEY
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//A retrofit service to fetch movie playlist.
interface MovieApi {

    @GET("movie/{category}")
    suspend fun getPropertyAsync(
        @Path("category") category: String,
        @Query("api_key") key: String = API_KEY,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Results


//    @GET("movie/{category}")
//    suspend fun getListOfPosters(
//        @Path("category") category: String,
//        @Query("api_key") key: String = API_KEY,
//        @Query("language") language: String
//    ): SmallMovie


//    @GET("movie/{id}?api_key=$API_KEY&language=ru")
//    suspend fun getMovieByID(@Path("id") id: Int): MovieInfo
}