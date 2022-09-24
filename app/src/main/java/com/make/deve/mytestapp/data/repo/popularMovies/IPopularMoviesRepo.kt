package com.make.deve.mytestapp.data.repo.popularMovies

import com.make.deve.mytestapp.ui.popularMovies.GetDataPopularMoviesResponseModel

interface IPopularMoviesRepo {
    suspend fun getDataCompany(): GetDataPopularMoviesResponseModel
}