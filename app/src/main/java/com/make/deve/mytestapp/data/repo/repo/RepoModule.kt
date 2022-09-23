package com.make.deve.mytestapp.data.repo.repo

import com.make.deve.mytestapp.di.BaseModule
import com.make.deve.mytestapp.data.repo.ErrorMapper
import com.make.deve.mytestapp.data.repo.IErrorMapper
import org.koin.core.module.Module
import org.koin.dsl.module

object RepoModule : BaseModule() {

    override val modules: List<Module>
        get() = listOf(module)

    private val module = module {
        single<IErrorMapper> { ErrorMapper() }
    }
}