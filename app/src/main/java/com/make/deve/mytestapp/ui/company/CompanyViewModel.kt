package com.make.deve.mytestapp.ui.company

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.make.deve.mytestapp.data.repo.popularMovies.ICompanyRepo
import com.make.deve.mytestapp.ui.util.BaseViewModel
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class CompanyViewModel: BaseViewModel(), KoinComponent {

    val repo: ICompanyRepo by inject()
    val listofCompany: MutableLiveData<GetDataCompanyResponseModel> = MutableLiveData()

    fun getCompanyUser() {
        viewModelScope.launch {
            loading.value = true


            val rem = repo.getDataCompany()
            listofCompany.value = rem

            loading.value = false
        }
    }

}