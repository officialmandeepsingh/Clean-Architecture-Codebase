package com.mandeepspurwa.mvvmcodebase.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mandeepspurwa.mvvmcodebase.data.models.Movie
import com.mandeepspurwa.mvvmcodebase.data.repository.RemoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * App Name: MVVM Codebase
 * Package Name: com.mandeepspurwa.mvvmcodebase.ui.viewModel
 * Author : Mandeep Singh
 * Email Id: officialmandeepsp@gmail.com
 * Date: Mon 01 May, 2023
 *
 **/

@HiltViewModel
class AppViewModel @Inject constructor(val remoteRepository: RemoteRepository) : ViewModel(){
    fun getPopularMovies(): Flow<PagingData<Movie>> {
        return remoteRepository.PopularMovie().cachedIn(viewModelScope)
    }
}