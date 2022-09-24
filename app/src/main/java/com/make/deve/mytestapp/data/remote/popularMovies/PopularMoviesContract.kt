package com.make.deve.mytestapp.data.remote.popularMovies

import retrofit2.Response
import retrofit2.http.*

interface PopularMoviesContract {

    @GET("/3/movie/popular/")
    suspend fun getDataMovies(@Query("api_key")apiKey: String): Response<String>
}