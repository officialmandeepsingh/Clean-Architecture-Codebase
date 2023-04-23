package com.mandeepspurwa.mvvmcodebase.data.base

/**
 * App Name: MVVM Codebase
 * Package Name: com.mandeepspurwa.mvvmcodebase.data.base
 * Author : Mandeep Singh
 * Email Id: officialmandeepsp@gmail.com
 * Date: Sun 23 Apr, 2023
 *
 **/
sealed class ApiResponse<out T> {

    data class Success<out T>(
        val apiData: T?
    ) : ApiResponse<T>()

    data class Failure<out T>(
        val statusCode: Int, val statusMessage: String, val apiData: T?,
        val throwable: Throwable? = null
    ) : ApiResponse<T>()

}
