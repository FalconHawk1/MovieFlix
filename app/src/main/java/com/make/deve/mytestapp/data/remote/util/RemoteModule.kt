package com.make.deve.mytestapp.data.remote.util

import com.make.deve.mytestapp.di.BaseModule
import com.make.deve.mytestapp.data.remote.errorManager.IRemoteErrorManager
import com.make.deve.mytestapp.data.remote.errorManager.RemoteErrorManager
import org.koin.core.module.Module
import org.koin.dsl.module

object RemoteModule : BaseModule() {

    override val modules: List<Module>
        get() = listOf(module)

    private val module = module {
        single<IRemoteErrorManager> { RemoteErrorManager() }
    }
}