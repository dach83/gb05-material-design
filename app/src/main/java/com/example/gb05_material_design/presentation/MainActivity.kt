package com.example.gb05_material_design.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.gb05_material_design.R
import com.example.gb05_material_design.databinding.ActivityMainBinding
import com.example.gb05_material_design.domain.ThemePreferencesHelper
import com.example.gb05_material_design.presentation.picture_of_the_day.PictureOfTheDayFragment
import com.example.gb05_material_design.presentation.picture_of_the_day_pager.PictureOfTheDayPagerFragment
import com.example.gb05_material_design.presentation.switch_theme.SwitchThemeFragment
import com.example.gb05_material_design.presentation.todo_list.TodoListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), PictureOfTheDayFragment.Controller {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    private var showLogo = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
            .setKeepOnScreenCondition { showLogo }
        setupTheme()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNav()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setupTheme() {
        val themeId = ThemePreferencesHelper.readTheme(this)
        setTheme(themeId)
    }

    private fun setupBottomNav() {
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.picture_of_the_day_menu -> PictureOfTheDayPagerFragment()
                R.id.switch_theme_menu -> SwitchThemeFragment()
                R.id.todo_list_menu -> TodoListFragment()
                else -> null
            }?.also { fragment ->
                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_fragment_container, fragment)
                    .commit()
            }
            true
        }
    }

    override fun onLoadedPictureOfTheDay() {
        showLogo = false
        Log.d("@@@", "onLoadedPictureOfTheDay: ")
    }

}