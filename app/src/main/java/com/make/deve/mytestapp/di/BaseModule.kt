package com.make.deve.mytestapp.di

import org.koin.core.module.Module

abstract class BaseModule {
    abstract val modules: List<Module>
}