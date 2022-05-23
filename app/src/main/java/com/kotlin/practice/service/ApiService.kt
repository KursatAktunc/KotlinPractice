package com.kotlin.practice.service

import com.kotlin.practice.models.Products
import com.kotlin.practice.models.pokedex.Pokemon
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getAllProducts(): Response<List<Products>>

    @GET("pokemon.json")
    suspend fun getAllPokemon():Response<List<Pokemon>>
}