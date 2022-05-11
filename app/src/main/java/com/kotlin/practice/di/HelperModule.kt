package com.kotlin.practice.di

import android.content.Context
import com.kotlin.practice.util.StringHelper
import com.kotlin.practice.util.ToastHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HelperModule {

    @Provides
    fun provideStringHelper(@ApplicationContext context: Context): StringHelper =
        StringHelper(context)

    @Provides
    fun provideToastHelper(@ApplicationContext context: Context): ToastHelper = ToastHelper(context)
}