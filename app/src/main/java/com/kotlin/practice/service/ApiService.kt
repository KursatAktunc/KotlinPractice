package com.kotlin.practice.service

import com.kotlin.practice.models.Products
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getAllProducts(): Response<List<Products>>
}