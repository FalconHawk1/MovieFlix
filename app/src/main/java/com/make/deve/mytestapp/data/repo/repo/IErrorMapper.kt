package com.make.deve.mytestapp.data.repo

import com.make.deve.mytestapp.data.remote.util.RemoteErrorModel
import com.make.deve.mytestapp.ui.util.BaseUIDataError
import com.make.deve.mytestapp.ui.util.ErrorActions

interface IErrorMapper : Mapper<RemoteErrorModel?, BaseUIDataError>

class ErrorMapper : IErrorMapper {
    override fun map(input: RemoteErrorModel?): BaseUIDataError {

        val action: ErrorActions = when (input?.code) {
            //412, 401 -> ErrorActions.LOGOUT
            else -> ErrorActions.NONE
        }

        return if (input != null)
            BaseUIDataError(
                id = input.code,
                message = "${input.error_description} (${input.code})",
                title = "Alerta!",
                action = action
            )
        else BaseUIDataError.getDefaultUIError()
    }
}