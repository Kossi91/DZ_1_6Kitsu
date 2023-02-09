package com.example.dz_1_6kitsu.di

import android.content.Context
import com.example.dz_1_6kitsu.data.locale.preferences.PreferencesHelper
import com.example.dz_1_6kitsu.data.locale.preferences.UserPreferencesData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Singleton
    @Provides
    fun providePreferenceHelper(@ApplicationContext context: Context) =
        PreferencesHelper(context)

    @Singleton
    @Provides
    fun provideUserPreferenceData(preferencesHelper: PreferencesHelper) =
        UserPreferencesData(preferencesHelper)
}