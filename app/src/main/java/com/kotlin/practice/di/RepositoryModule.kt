package com.kotlin.practice.di

import com.kotlin.practice.repository.ProductsRepository
import com.kotlin.practice.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideProductsRepository(apiService: ApiService): ProductsRepository = ProductsRepository(apiService)
}