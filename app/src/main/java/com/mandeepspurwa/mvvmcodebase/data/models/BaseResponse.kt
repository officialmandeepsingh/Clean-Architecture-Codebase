package com.mandeepspurwa.mvvmcodebase.data.models

import com.google.gson.annotations.SerializedName

/**
 * App Name: MVVM Codebase
 * Package Name: com.mandeepspurwa.mvvmcodebase.data.models
 * Author : Mandeep Singh
 * Email Id: officialmandeepsp@gmail.com
 * Date: Mon 24 Apr, 2023
 *
 **/
data class BaseResponse<T>(
    @SerializedName("dates")
    val dates: Dates?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: T,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)

data class Dates(
    @SerializedName("maximum")
    val maximum: String?,
    @SerializedName("minimum")
    val minimum: String?
)