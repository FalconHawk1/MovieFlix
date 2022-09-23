package com.make.deve.mytestapp.data.remote.popularMovies

import com.make.deve.mytestapp.data.remote.util.RemoteResponseModel

data class GetDataResponseModel(
    val items: List<DataItem> = listOf()
) : RemoteResponseModel() {
    data class DataItem(
        val title: String = "", val poster_path: String = "", val overview:String=""
    )
}