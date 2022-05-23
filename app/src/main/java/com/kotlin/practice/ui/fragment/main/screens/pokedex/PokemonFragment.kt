package com.kotlin.practice.ui.fragment.main.screens.pokedex

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.kotlin.practice.R
import com.kotlin.practice.base.BaseFragment
import com.kotlin.practice.base.ResourceStatus
import com.kotlin.practice.databinding.FragmentPokemonBinding
import com.kotlin.practice.ui.fragment.main.screens.pokedex.adapter.PokemonAdapter
import com.kotlin.practice.util.ToastHelper
import com.kotlin.practice.util.extensions.hide
import com.kotlin.practice.util.extensions.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG: String = "PokemonFragment"

@AndroidEntryPoint
class PokemonFragment : BaseFragment<FragmentPokemonBinding, PokemonFragmentViewModel>() {

    override val mViewModel: PokemonFragmentViewModel by viewModels()

    override fun bindLayoutId(): Int = R.layout.fragment_pokemon

    private lateinit var adapter: PokemonAdapter

    @Inject
    lateinit var toastHelper: ToastHelper

    override fun initViews() {
        mBinding.viewModel = mViewModel

        mViewModel.getAllPokemon()
        viewLifecycleOwner.lifecycleScope.launch {
            mViewModel.pokeResource.collect {
                when (it.status) {
                    ResourceStatus.PROGRESS -> {
                        Log.v(TAG, "progress")
                        mBinding.shimmer.startShimmer()
                    }
                    ResourceStatus.SUCCESS -> {
                        Log.v(TAG, "success")
                        adapter = PokemonAdapter(it.data!!)
                        mBinding.productsRV.adapter = adapter
                        mBinding.shimmer.stopShimmer()
                        mBinding.shimmer.hide()
                        mBinding.productsRV.show()
                    }
                    ResourceStatus.ERROR -> {
                        Log.v(TAG, mViewModel.pokeResource.value.error?.errorMessage.toString())
                        mViewModel.getAllPokemon()
                    }
                }
            }
        }
    }
}