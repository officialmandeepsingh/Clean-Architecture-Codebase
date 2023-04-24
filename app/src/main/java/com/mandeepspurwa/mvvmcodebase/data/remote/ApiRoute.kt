package com.mandeepspurwa.mvvmcodebase.data.remote

/**
 * App Name: MVVM Codebase
 * Package Name: com.mandeepspurwa.mvvmcodebase.data.remote
 * Author : Mandeep Singh
 * Email Id: officialmandeepsp@gmail.com
 * Date: Mon 24 Apr, 2023
 *
 **/
object ApiRoute {
    const val GET_DETAILS = "movie/{movie_id}"
    const val GET_POPULAR = "movie/popular"
    const val GET_NOW_PLAYING = "movie/now_playing"
    const val GET_LATEST = "movie/latest"
    const val GET_TOP_RATED = "movie/top_rated"
    const val GET_UPCOMING = "movie/upcoming"
    const val GET_SIMILAR_MOVIES = "movie/{movie_id}/similar"
}