package com.make.deve.mytestapp.di

import com.make.deve.mytestapp.data.remote.popularMovies.PopularMoviesServiceModule
import com.make.deve.mytestapp.data.remote.util.RemoteModule
import com.make.deve.mytestapp.data.repo.popularMovies.PopularMoviesRepoModule
import com.make.deve.mytestapp.data.repo.repo.RepoModule
import com.make.deve.mytestapp.ui.main.MainModule
import org.koin.core.module.Module

object Modules {
    fun getAllModules(): List<Module> {
        val allModules = ArrayList<Module>()

        //region Bases
        allModules.addAll(RemoteModule)
        allModules.addAll(RepoModule)
        //endregion

        //region Service Modules
        allModules.addAll(PopularMoviesServiceModule)
        //endregion

        //region Repo Modules
        allModules.addAll(PopularMoviesRepoModule)
        //endregion

        //region UI Modules
        allModules.addAll(MainModule)
        //endregion

        return allModules
    }
}

fun ArrayList<Module>.addAll(mod: BaseModule) {
    addAll(mod.modules)
}