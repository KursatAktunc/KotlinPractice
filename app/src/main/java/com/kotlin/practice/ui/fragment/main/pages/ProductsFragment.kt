package com.kotlin.practice.ui.fragment.main.pages

import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.kotlin.practice.R
import com.kotlin.practice.adapter.ProductsAdapter
import com.kotlin.practice.base.BaseFragment
import com.kotlin.practice.base.ResourceStatus
import com.kotlin.practice.databinding.FragmentProductsBinding
import com.kotlin.practice.viewmodel.ProductsFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : BaseFragment<FragmentProductsBinding, ProductsFragmentViewModel>() {

    override val mViewModel: ProductsFragmentViewModel by viewModels()

    override fun bindLayoutId(): Int = R.layout.fragment_products

    private lateinit var adapter: ProductsAdapter

    override fun initViews() {
        mBinding.viewModel = mViewModel

        mViewModel.getAllProducts()
        mViewModel.resource.observe(viewLifecycleOwner) {
            when (it.status) {
                ResourceStatus.PROGRESS -> {
                    Log.v("TAG", "progress")
                    mBinding.productProgressBar.visibility= View.VISIBLE
                }
                ResourceStatus.SUCCESS -> {
                    Log.v("TAG", "success")
                    adapter = ProductsAdapter(it.data!!)
                    mBinding.productsRV.adapter = adapter
                    mBinding.productProgressBar.visibility= View.GONE
                }
                ResourceStatus.ERROR -> {
                    Log.v("TAG", "error")
                    mBinding.productProgressBar.visibility= View.GONE
                }
            }
        }
    }
}