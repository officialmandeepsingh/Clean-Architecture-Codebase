package com.mandeepspurwa.mvvmcodebase.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mandeepspurwa.mvvmcodebase.data.models.Movie
import com.mandeepspurwa.mvvmcodebase.data.pagging.PopularMoviePagingSource
import com.mandeepspurwa.mvvmcodebase.data.remote.NetworkService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * App Name: MVVM Codebase
 * Package Name: com.mandeepspurwa.mvvmcodebase.data.repository
 * Author : Mandeep Singh
 * Email Id: officialmandeepsp@gmail.com
 * Date: Mon 01 May, 2023
 *
 **/
class RemoteRepository @Inject constructor(val networkService: NetworkService) {
    private val config = PagingConfig(20, 4, true, 20)

    fun PopularMovie(): Flow<PagingData<Movie>>{
        return Pager(config){
            PopularMoviePagingSource(networkService)
        }.flow
    }

}