package com.make.deve.mytestapp.data.repo.popularMovies

import com.make.deve.mytestapp.data.remote.popularMovies.IPopularMoviesService
import com.make.deve.mytestapp.data.repo.repo.BaseRepo
import com.make.deve.mytestapp.ui.popularMovies.CompanyItem
import com.make.deve.mytestapp.ui.popularMovies.GetDataPopularMoviesResponseModel
import com.make.deve.mytestapp.ui.util.BaseUIDataError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PopularMoviesRepo(
    private val service: IPopularMoviesService,
) : BaseRepo(),
    IPopularMoviesRepo {
    override suspend fun getDataCompany(): GetDataPopularMoviesResponseModel  = withContext(Dispatchers.IO) {
        var res = GetDataPopularMoviesResponseModel()

        try {
            val rem = service.getData()
            if (rem.errorModel == null) {
                res = GetDataPopularMoviesResponseModel(
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