package com.kotlin.practice.ui.fragment.main.pages

import androidx.fragment.app.viewModels
import com.kotlin.practice.R
import com.kotlin.practice.base.BaseFragment
import com.kotlin.practice.databinding.FragmentProductsBinding
import com.kotlin.practice.viewmodel.ProductsFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : BaseFragment<FragmentProductsBinding, ProductsFragmentViewModel>() {

    override val mViewModel: ProductsFragmentViewModel by viewModels()

    override fun bindLayoutId(): Int = R.layout.fragment_products

    override fun initViews() {
        mBinding.viewModel = mViewModel
    }
}