package com.mandeepspurwa.mvvmcodebase.data.base

/**
 * App Name: MVVM Codebase
 * Package Name: com.mandeepspurwa.mvvmcodebase.data.base
 * Author : Mandeep Singh
 * Email Id: officialmandeepsp@gmail.com
 * Date: Sun 23 Apr, 2023
 *
 **/
sealed class Resource<T>(
    val data: T? = null,
    val status: Status = Status.LOADING,
    val message: String? = null,
    val error: String? = null,
) {
    class Succes<T>(data: T? = null, status: Status = Status.SUCCESS, message: String? = null) :
        Resource<T>(data, status, message)

    class Loading<T>(data: T? = null) : Resource<T>(data = data)

    class Error<T>(status: Status = Status.FAILURE, error: String? = null) :
        Resource<T>(status = status, error = error)

    class UnAuthorized<T>(
        data: T? = null,
        status: Status = Status.UNAUTHORIZED,
        message: String? = null,
    ) : Resource<T>(data = data, status = status, message = message)
}
