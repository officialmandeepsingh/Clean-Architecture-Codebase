package com.mandeepspurwa.mvvmcodebase.data.pagging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mandeepspurwa.mvvmcodebase.data.base.ApiResponse
import com.mandeepspurwa.mvvmcodebase.data.base.NetworkRequest
import com.mandeepspurwa.mvvmcodebase.data.models.Movie
import com.mandeepspurwa.mvvmcodebase.data.remote.NetworkService

/**
 * App Name: MVVM Codebase
 * Package Name: com.mandeepspurwa.mvvmcodebase.data.pagging
 * Author : Mandeep Singh
 * Email Id: officialmandeepsp@gmail.com
 * Date: Wed 03 May, 2023
 *
 **/
class PopularMoviePagingSource(private val networkService: NetworkService) : PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return 1
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val key = params.key ?: 1
        return  try{
            val data = NetworkRequest.processApi { networkService.getPopularMovies(key) }.run {
                when(this){
                    is ApiResponse.Success -> {
                        apiData ?: throw Exception("Error while fetching popular Movies List")
                    }
                    is ApiResponse.Failure -> {
                        throw Exception("Error while fetching popular Movies List")
                    }
                }
            }
            val movies = data.results ?: emptyList()
            val nextPage = data.page?.plus(1)
            LoadResult.Page(movies, null, nextPage)
        }catch (e: Exception){
            LoadResult.Error(e)
        }
    }
}