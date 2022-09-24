package com.make.deve.mytestapp.data.remote.popularMovies

interface IPopularMoviesService {

    suspend fun getData(): GetDataResponseModel

}