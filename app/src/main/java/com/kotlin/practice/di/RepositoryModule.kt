package com.kotlin.practice.di

import android.content.Context
import com.kotlin.practice.repository.PokemonRepository
import com.kotlin.practice.repository.OnBoardingRepository
import com.kotlin.practice.repository.ProductsRepository
import com.kotlin.practice.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideProductsRepository(apiService: ApiService): ProductsRepository =
        ProductsRepository(apiService)

    @Provides
    fun provideOnBoardingRepository(@ApplicationContext context: Context) =
        OnBoardingRepository(context = context)

    @Provides
    fun provideFavoriteRepository(apiService: ApiService): PokemonRepository =
        PokemonRepository(apiService)
}