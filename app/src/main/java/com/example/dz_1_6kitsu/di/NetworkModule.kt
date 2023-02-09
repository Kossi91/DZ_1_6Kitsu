package com.example.dz_1_6kitsu.di

import com.example.dz_1_6kitsu.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitClient() = RetrofitClient()

    @Singleton
    @Provides
    fun provideAnimeApiService(retrofitClient: RetrofitClient) = retrofitClient.provideAnimeApiService()

    @Singleton
    @Provides
    fun provideMangaApiService(retrofitClient: RetrofitClient) = retrofitClient.provideMangaApiService()

    @Singleton
    @Provides
    fun provideSignInApiService(retrofitClient: RetrofitClient) = retrofitClient.providerSignInApiService()
}