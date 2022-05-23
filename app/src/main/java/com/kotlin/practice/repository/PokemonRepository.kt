package com.kotlin.practice.repository

import com.kotlin.practice.service.ApiService
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val retrofitService: ApiService) {
    suspend fun getAllPokemon() = retrofitService.getAllPokemon()
}