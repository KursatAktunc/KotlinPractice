package com.kotlin.practice.repository

import com.kotlin.practice.service.ApiService
import javax.inject.Inject

class ProductsRepository @Inject constructor(private val retrofitService: ApiService) {
    suspend fun getAllProducts() = retrofitService.getAllProducts()
}