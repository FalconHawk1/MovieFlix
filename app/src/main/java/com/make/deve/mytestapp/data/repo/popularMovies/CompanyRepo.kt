package com.make.deve.mytestapp.data.repo.popularMovies

import com.make.deve.mytestapp.data.remote.popularMovies.ICompanyService
import com.make.deve.mytestapp.data.repo.repo.BaseRepo
import com.make.deve.mytestapp.ui.company.CompanyItem
import com.make.deve.mytestapp.ui.company.GetDataCompanyResponseModel
import com.make.deve.mytestapp.ui.util.BaseUIDataError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CompanyRepo(
    private val service: ICompanyService,
) : BaseRepo(),
    ICompanyRepo {
    override suspend fun getDataCompany(): GetDataCompanyResponseModel  = withContext(Dispatchers.IO) {
        var res = GetDataCompanyResponseModel()

        try {
            val rem = service.getData()
            if (rem.errorModel == null) {
                res = GetDataCompanyResponseModel(
                    items = rem.items.map {
                        CompanyItem(
                            title = it.title,
                            overview = it.overview,
                            poster_path = it.poster_path

                        )

                    }
                )

            } else {
                res.error = errorMapper.map(rem.errorModel)
            }
        } catch (ex: Exception) {
            res.error = BaseUIDataError.getErrorFromException(ex)
        }

        return@withContext res
    }
}