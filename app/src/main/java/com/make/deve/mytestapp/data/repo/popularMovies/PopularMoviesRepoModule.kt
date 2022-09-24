package com.make.deve.mytestapp.data.repo.popularMovies

import com.make.deve.mytestapp.di.BaseModule
import org.koin.core.module.Module
import org.koin.dsl.module

object PopularMoviesRepoModule : BaseModule() {
    private val mod = module { single<IPopularMoviesRepo> { PopularMoviesRepo(get()) } }
    override val modules: List<Module>
        get() = listOf(mod)
}