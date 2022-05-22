package com.example.gb05_material_design.domain

import android.content.Context
import android.content.SharedPreferences
import com.example.gb05_material_design.R

object ThemePreferencesHelper {

    private const val THEME_PREFS = "theme_prefs"
    private const val KEY_THEME_ID = "theme_id"

    private fun themePreferences(context: Context): SharedPreferences =
        context.getSharedPreferences(
            THEME_PREFS, Context.MODE_PRIVATE
        )

    fun readTheme(context: Context, defaultThemeId: Int = R.style.SimpleTheme): Int =
        themePreferences(context)
            .getInt(KEY_THEME_ID, defaultThemeId)

    fun saveTheme(context: Context, themeId: Int) =
        themePreferences(context)
            .edit()
            .putInt(KEY_THEME_ID, themeId)
            .apply()

}