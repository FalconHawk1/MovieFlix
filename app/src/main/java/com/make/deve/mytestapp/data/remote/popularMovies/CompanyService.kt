package com.make.deve.mytestapp.data.remote.popularMovies

import android.util.Log
import com.make.deve.mytestapp.data.remote.util.BaseRetrofitService
import org.json.JSONArray
import org.json.JSONObject

class CompanyService: BaseRetrofitService(),ICompanyService {

    val apiKey = "f5ca92d82c4ef81bad43458d6fdbbe5a"


    override val contract: CompanyContract
        get() = build(CompanyContract::class.java)

    override suspend fun getData(): GetDataResponseModel {
        var res = GetDataResponseModel()
        try {

            val rem = contract.getDataMovies("$apiKey")
            println(rem)
            println(rem.body())
            if (rem.isSuccessful) {
                Log.d("TAG", "getData: ${rem.body()}")
                val remoteAssignedList = JSONObject(rem.body()!!)

                val result = remoteAssignedList.getString("results")
                val resultArray = JSONArray(result)
                Log.d("TAGI", "getData: ${result}")
                val itemsModel = mutableListOf<GetDataResponseModel.DataItem>()
                for (i in 0 until resultArray.length()) {
                    val item = resultArray[i] as JSONObject
                    itemsModel.add(
                        GetDataResponseModel.DataItem(
                            title = item.getString("title"),
                            overview = item.getString("overview"),
                            poster_path = item.getString("poster_path")

                        )
                    )
                }


                res = GetDataResponseModel(itemsModel)
            } else {
                res.errorModel = errorManager.getErrorFromBody(rem.errorBody(), rem.code())
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
            res.errorModel = errorManager.getErrorFromException(ex)
        }

        return res
    }
}