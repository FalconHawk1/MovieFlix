package com.make.deve.mytestapp.ui.company

import com.make.deve.mytestapp.ui.util.BaseUIData

data class GetDataCompanyResponseModel(
    val items: List<CompanyItem> = listOf()
): BaseUIData()

data class CompanyItem(
    val title: String = "", val overview: String = "", val poster_path:String=""
)
