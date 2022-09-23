package com.make.deve.mytestapp.data.remote.popularMovies

interface ICompanyService {

    suspend fun getData(): GetDataResponseModel

}