package com.mandeepspurwa.mvvmcodebase.data.remote

import com.mandeepspurwa.mvvmcodebase.data.models.BaseResponse
import com.mandeepspurwa.mvvmcodebase.data.models.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * App Name: MVVM Codebase
 * Package Name: com.mandeepspurwa.mvvmcodebase.data.remote
 * Author : Mandeep Singh
 * Email Id: officialmandeepsp@gmail.com
 * Date: Mon 24 Apr, 2023
 *
 **/
interface NetworkService {

    @GET(ApiRoute.GET_POPULAR)
    suspend fun getPopularMovies(@Query("page") key: Int): Response<BaseResponse<List<Movie>>>

    @GET(ApiRoute.GET_NOW_PLAYING)
    suspend fun getNowPlayingMovies(@Query("page") key: Int): Response<BaseResponse<List<Movie>>>

    @GET(ApiRoute.GET_LATEST)
    suspend fun getLatestMovies(@Query("page") key: Int): Response<BaseResponse<Movie>>

    @GET(ApiRoute.GET_TOP_RATED)
    suspend fun getTopRatedMovies(@Query("page") key: Int): Response<BaseResponse<List<Movie>>>

    @GET(ApiRoute.GET_UPCOMING)
    suspend fun getUpcomingMovies(@Query("page") key: Int): Response<BaseResponse<List<Movie>>>

    @GET(ApiRoute.GET_DETAILS)
    suspend fun getMovieDetail(@Path("movie_id") movieId: String): Response<Movie>

}