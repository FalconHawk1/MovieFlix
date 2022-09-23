package com.make.deve.mytestapp.resources

import androidx.annotation.StringRes
import com.make.deve.mytestapp.ui.App

object Strings {

    fun get(@StringRes stringRes: Int, vararg formatArgs: Any = emptyArray()): String {
        return App.instance.getString(stringRes, *formatArgs)
    }
}