package com.bohunapps.appsbuildingtest.di

import android.content.Context
import com.bohunapps.appsbuildingtest.repository.SharedPrefsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class HiltModule {
    @Provides
    fun provideSharedPrefsRepo(@ApplicationContext context: Context) = SharedPrefsRepo(context)
}