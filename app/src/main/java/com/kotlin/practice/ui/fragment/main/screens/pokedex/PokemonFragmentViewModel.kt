package com.kotlin.practice.ui.fragment.main.screens.pokedex

import androidx.lifecycle.viewModelScope
import com.kotlin.practice.base.BaseViewModel
import com.kotlin.practice.base.Resource
import com.kotlin.practice.base.ResourceError
import com.kotlin.practice.base.ResourceStatus
import com.kotlin.practice.models.pokedex.Pokemon
import com.kotlin.practice.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonFragmentViewModel @Inject constructor(private val repository: PokemonRepository) :
    BaseViewModel() {

    private val _pokeResource =
        MutableStateFlow<Resource<List<Pokemon>>>(Resource(ResourceStatus.PROGRESS))
    val pokeResource: StateFlow<Resource<List<Pokemon>>> = _pokeResource

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _pokeResource.value = Resource(
            ResourceStatus.ERROR,
            null,
            throwable.localizedMessage?.let { ResourceError(62, it) })
    }

    fun getAllPokemon() {
        _pokeResource.value = Resource(ResourceStatus.PROGRESS)

        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val response = repository.getAllPokemon()

            if (response.isSuccessful)
                _pokeResource.value = Resource(ResourceStatus.SUCCESS, response.body())
            else
                _pokeResource.value =
                    Resource(ResourceStatus.ERROR, null, ResourceError(61, response.message()))
        }
    }
}