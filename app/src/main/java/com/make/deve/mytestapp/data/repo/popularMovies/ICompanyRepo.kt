package com.make.deve.mytestapp.data.repo.popularMovies

import com.make.deve.mytestapp.ui.company.GetDataCompanyResponseModel

interface ICompanyRepo {
    suspend fun getDataCompany(): GetDataCompanyResponseModel
}