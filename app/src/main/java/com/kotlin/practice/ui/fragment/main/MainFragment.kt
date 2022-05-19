package com.kotlin.practice.ui.fragment.main

import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kotlin.practice.R
import com.kotlin.practice.base.BaseFragment
import com.kotlin.practice.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding, MainFragmentViewModel>() {

    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    override val mViewModel: MainFragmentViewModel by viewModels()

    override fun bindLayoutId(): Int = R.layout.fragment_main

    override fun initViews() {
        mBinding.viewModel = mViewModel

        (activity as AppCompatActivity?)!!.supportActionBar!!.show()

        /* val navHostFragment = childFragmentManager.findFragmentById(R.id.fragmentContainerView2)
                 as NavHostFragment
         val navController = navHostFragment.navController*/

        setHasOptionsMenu(true) //TODO Deprecated search and fix

        actionBarDrawerToggle =
            ActionBarDrawerToggle(requireActivity(), mBinding.drawerLayout, 0, 0)
        mBinding.drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        actionBarDrawerToggle.isDrawerSlideAnimationEnabled = true
        actionBarDrawerToggle.isDrawerIndicatorEnabled = true

        mBinding.bottomNavigation.setOnItemSelectedListener { item ->
            if (mBinding.bottomNavigation.selectedItemId == item.itemId) {
                return@setOnItemSelectedListener false
            }
            when (item.itemId) {
                R.id.page_1 -> {
                    /*navHostFragment.findNavController().navigate(R.id.productsFragment)*/
                    childFragmentManager.primaryNavigationFragment?.findNavController()
                        ?.navigate(R.id.productsFragment)
                    true
                }
                R.id.page_2 -> {
                    childFragmentManager.primaryNavigationFragment?.findNavController()
                        ?.navigate(R.id.favoriteFragment)
                    true
                }
                R.id.page_3 -> {
                    //setFragment(ProductsFragment())
                    true
                }
                else -> false
            }
        }

        //mBinding.bottomNavigation.setOnNavigationItemReselectedListener { } is deprecated bunun yerine if sorgusu ile kontrol sağladım
    }

    /*private fun setFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView2, fragment)
            commit()
        }
    }*/

    /*override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        (activity as AppCompatActivity?)!!.supportActionBar!!.show()

        setHasOptionsMenu(true)

        actionBarDrawerToggle = ActionBarDrawerToggle(requireActivity(), binding.drawerLayout, 0, 0)
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        actionBarDrawerToggle.isDrawerSlideAnimationEnabled = true
        actionBarDrawerToggle.isDrawerIndicatorEnabled = true

        return binding.root
    }*/

    //TODO Deprecated search and fix
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }
}