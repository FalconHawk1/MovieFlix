package com.make.deve.mytestapp.data.remote.errorManager

import com.make.deve.mytestapp.data.remote.util.RemoteErrorModel
import okhttp3.ResponseBody

interface IRemoteErrorManager {

    fun getErrorFromBody(errorBody: ResponseBody?, httpCode: Int): RemoteErrorModel
    fun getErrorFromException(ex: Exception): RemoteErrorModel

}