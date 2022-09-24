package com.make.deve.mytestapp.ui.popularMovies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.make.deve.mytestapp.data.repo.popularMovies.IPopularMoviesRepo
import com.make.deve.mytestapp.ui.util.BaseViewModel
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class HomeViewModel: BaseViewModel(), KoinComponent {

    val repo: IPopularMoviesRepo by inject()
    val listofPopularMovies: MutableLiveData<GetDataPopularMoviesResponseModel> = MutableLiveData()

    fun getCompanyUser() {
        viewModelScope.launch {
            loading.value = true


            val rem = repo.getDataCompany()
            listofPopularMovies.value = rem

            loading.value = false
        }
    }

}