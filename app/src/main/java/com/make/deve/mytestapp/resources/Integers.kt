package com.make.deve.mytestapp.resources

import androidx.annotation.IntegerRes
import com.make.deve.mytestapp.ui.App

object Integers {
    fun get(@IntegerRes stringRes: Int): Int {
        return App.instance.resources.getInteger(stringRes)
    }
}