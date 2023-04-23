package com.mandeepspurwa.mvvmcodebase

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * App Name: MVVM Codebase
 * Package Name: com.mandeepspurwa.mvvmcodebase
 * Author : Mandeep Singh
 * Email Id: officialmandeepsp@gmail.com
 * Date: Sun 23 Apr, 2023
 *
 **/
@HiltAndroidApp
class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}