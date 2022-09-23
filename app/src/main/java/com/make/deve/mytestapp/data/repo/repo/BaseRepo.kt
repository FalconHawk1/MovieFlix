package com.make.deve.mytestapp.data.repo.repo

import com.make.deve.mytestapp.data.repo.IErrorMapper
import org.koin.core.KoinComponent
import org.koin.core.inject

open class BaseRepo : KoinComponent {

    val errorMapper: IErrorMapper by inject()

}