package com.make.deve.mytestapp.ui.main

import com.make.deve.mytestapp.di.BaseModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object MainModule : BaseModule() {
    override val modules: List<Module>
        get() = listOf(mod)

    private val mod = module {
        viewModel { MainViewModel() }
    }
}