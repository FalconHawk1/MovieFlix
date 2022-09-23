package com.make.deve.mytestapp.ui.util

import com.make.deve.mytestapp.R
import com.make.deve.mytestapp.resources.Integers
import com.make.deve.mytestapp.resources.Strings

open class BaseUIData(
    open var error: BaseUIDataError? = null
)

data class BaseUIDataError(
    var id: Int = 0,
    var title: String? = null,
    var message: String = "",
    var action: ErrorActions = ErrorActions.NONE
) {
    companion object {

        fun getErrorFromException(ex: Exception): BaseUIDataError {
            return when (ex) {

                else -> getDefaultUIError()
            }
        }


        fun getDefaultUIError(): BaseUIDataError {
            return BaseUIDataError(
                id = Integers.get(R.integer.error_ui_default),
                message = Strings.get(R.string.error_ui_default)
            )
        }
    }
}

enum class ErrorActions() {

    NONE,
    CLOSE,
    TRY_AGAIN,
    LOGOUT,
    ;

}