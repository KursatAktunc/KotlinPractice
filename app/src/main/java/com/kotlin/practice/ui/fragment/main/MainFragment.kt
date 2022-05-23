package com.kotlin.practice.ui.fragment.main

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import com.kotlin.practice.R
import com.kotlin.practice.base.BaseFragment
import com.kotlin.practice.databinding.FragmentMainBinding
import com.kotlin.practice.ui.fragment.main.screens.pokedex.PokemonFragment
import com.kotlin.practice.ui.fragment.main.screens.products.ProductsFragment
import com.kotlin.practice.util.ToastHelper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding, MainFragmentViewModel>() {

    override val mViewModel: MainFragmentViewModel by viewModels()
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration

    override fun bindLayoutId(): Int = R.layout.fragment_main

    @Inject
    lateinit var toastHelper: ToastHelper

    override fun initViews() {
        mBinding.viewModel = mViewModel

        (activity as AppCompatActivity?)!!.supportActionBar!!.show()

        setupViews()

        mBinding.bottomNavigation.setOnItemSelectedListener { item ->
            if (mBinding.bottomNavigation.selectedItemId == item.itemId) {
                return@setOnItemSelectedListener false
            }
            when (item.itemId) {
                R.id.page_1 -> {
                    /*navHostFragment.findNavController().navigate(R.id.productsFragment)*/
                    /*childFragmentManager.primaryNavigationFragment?.findNavController()?.navigate(R.id.productsFragment)*/

                    setFragment(ProductsFragment())
                    true
                }
                R.id.page_2 -> {
                    /*childFragmentManager.primaryNavigationFragment?.findNavController()?.navigate(R.id.favoriteFragment)*/

                    /*childFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView2, FavoriteFragment()).commit()*/

                    setFragment(PokemonFragment())
                    true
                }
                R.id.page_3 -> {
                    //setFragment(ProductsFragment())
                    true
                }
                else -> false
            }
        }

        /*val navHostFragment = childFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph, mBinding.drawerLayout)
        mBinding.navView.setupWithNavController(navController)*/
    }

    private fun setupViews() {
        //Navigation
        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.top_app_bar, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                if (actionBarDrawerToggle.onOptionsItemSelected(menuItem))
                    return true
                return when (menuItem.itemId) {
                    R.id.edit -> {
                        toastHelper.showToastLong("Clicked Edit")
                        true
                    }
                    R.id.favorite -> {
                        toastHelper.showToastLong("Clicked Favorite")
                        true
                    }
                    R.id.more -> {
                        toastHelper.showToastLong("Clicked More")
                        true
                    }
                    else -> false
                }
            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        actionBarDrawerToggle =
            ActionBarDrawerToggle(requireActivity(), mBinding.drawerLayout, 0, 0)
        mBinding.drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        actionBarDrawerToggle.isDrawerSlideAnimationEnabled = true
        actionBarDrawerToggle.isDrawerIndicatorEnabled = true
    }

    private fun setFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction().apply {
            setReorderingAllowed(true)
            setCustomAnimations(
                androidx.navigation.ui.R.anim.nav_default_enter_anim,
                androidx.navigation.ui.R.anim.nav_default_exit_anim,
                androidx.navigation.ui.R.anim.nav_default_pop_enter_anim,
                androidx.navigation.ui.R.anim.nav_default_pop_exit_anim
            )
            //addToBackStack(null)  Fragmentler arası geçiş yaptığımızda geri tuşu sırayla daha önceki açılan fragmentlere geri dönüyor. Bu kodu kullanmaz isek geri tuşu önceki fragmentlere geri dönmüyor
            replace(R.id.fragmentContainerView2, fragment)
            commit()
        }
    }

}
