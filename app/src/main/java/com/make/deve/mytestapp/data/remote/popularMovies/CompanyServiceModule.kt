package com.make.deve.mytestapp.data.remote.popularMovies

import com.make.deve.mytestapp.di.BaseModule
import org.koin.core.module.Module
import org.koin.dsl.module

object CompanyServiceModule: BaseModule() {
    private val mod: Module = module {
        single<ICompanyService> { CompanyService() }
    }

    override val modules: List<Module>
        get() = listOf(mod)
}