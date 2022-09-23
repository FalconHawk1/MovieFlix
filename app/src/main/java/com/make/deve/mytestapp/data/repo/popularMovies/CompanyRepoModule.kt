package com.make.deve.mytestapp.data.repo.popularMovies

import com.make.deve.mytestapp.di.BaseModule
import org.koin.core.module.Module
import org.koin.dsl.module

object CompanyRepoModule : BaseModule() {
    private val mod = module { single<ICompanyRepo> { CompanyRepo(get()) } }
    override val modules: List<Module>
        get() = listOf(mod)
}