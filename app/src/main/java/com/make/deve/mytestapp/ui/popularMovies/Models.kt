package com.make.deve.mytestapp.ui.popularMovies

import com.make.deve.mytestapp.ui.util.BaseUIData

data class GetDataPopularMoviesResponseModel(
    val items: List<CompanyItem> = listOf()
): BaseUIData()

data class CompanyItem(
    val title: String = "", val overview: String = "", val poster_path:String=""
)
