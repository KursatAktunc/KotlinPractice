package com.kotlin.practice.ui.activity

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.findNavController
import com.google.android.material.color.DynamicColors
import com.kotlin.practice.R
import com.kotlin.practice.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        WindowInsetsControllerCompat(window, window.decorView).hide(WindowInsetsCompat.Type.statusBars())
        //setSystemUIVisibility()
        //DynamicColors.applyToActivitiesIfAvailable(application)
    }

    //TODO Deprecated search and fix
    /*private fun setSystemUIVisibility() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val window = window.insetsController!!
            val windows = WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars()
            window.hide(windows)
            // needed for hide, doesn't do anything in show
            window.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        } else {
            val view = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            window.decorView.systemUiVisibility = view
        }
    }*/

    override fun onResume() {
        //setSystemUIVisibility()
        //WindowInsetsControllerCompat(window, window.decorView).hide(WindowInsetsCompat.Type.statusBars()) //Hem en üstteki statusbar'ı hem de gezinme çubuğunu gizlemek istersek Type.statusBars() yerine Type.systemBars() yapıyoruz
        super.onResume()
    }

    /*fun hideStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.decorView.windowInsetsController!!.hide(
                WindowInsets.Type.statusBars() //hide statusbar
                        or WindowInsets.Type.navigationBars() //hide navigation
            )
        }
    }*/
}


