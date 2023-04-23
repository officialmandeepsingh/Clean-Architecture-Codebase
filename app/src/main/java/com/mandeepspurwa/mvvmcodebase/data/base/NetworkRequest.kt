package com.mandeepspurwa.mvvmcodebase.data.base

import org.json.JSONObject
import retrofit2.Response

/**
 * App Name: MVVM Codebase
 * Package Name: com.mandeepspurwa.mvvmcodebase.data.base
 * Author : Mandeep Singh
 * Email Id: officialmandeepsp@gmail.com
 * Date: Sun 23 Apr, 2023
 *
 **/
object NetworkRequest {
    suspend fun <T> processApi(api: suspend () -> Response<T>): ApiResponse<T> {
        try {
            val response = api()
            val code = response.code()
            val body = response.body()
            return if (response.isSuccessful) {
                ApiResponse.Success(body)
            } else {
                val rawRes = response.errorBody()?.string() ?: "{}"
                val json = JSONObject(rawRes)
                val m = json.optString("message")
                ApiResponse.Failure(code, m, body)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return ApiResponse.Failure(
                statusCode = -1, statusMessage = e.message ?: "Something went wrong!",
                apiData = null, throwable = e
            )
        }
    }
}