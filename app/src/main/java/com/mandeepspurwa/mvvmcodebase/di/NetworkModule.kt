package com.mandeepspurwa.mvvmcodebase.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * App Name: MVVM Codebase
 * Package Name: com.mandeepspurwa.mvvmcodebase.di
 * Author : Mandeep Singh
 * Email Id: officialmandeepsp@gmail.com
 * Date: Sun 23 Apr, 2023
 *
 **/

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Singleton
    @Provides
    fun provideHttpClient(logging: HttpLoggingInterceptor): OkHttpClient {

        val request = Interceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url

            val url = originalHttpUrl.newBuilder()
//                .addQueryParameter("api_key", BuildConfig.API_KEY)
                .addQueryParameter("language", "en-US")
                .build()

            val requestBuilder = original.newBuilder()
                .url(url)
            val request = requestBuilder.build()
            return@Interceptor chain.proceed(request)

        }

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .addInterceptor(request)
            .build()


    }

    /*@Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient).build()*/


}