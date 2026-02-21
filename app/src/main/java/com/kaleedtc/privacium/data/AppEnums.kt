package com.kaleedtc.privacium.data

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.kaleedtc.privacium.R

enum class ThemeOption(val value: String) {
    Default("System Default"),
    DARK("dark"),
    LIGHT("light");

    companion object {
        fun fromValue(value: String): ThemeOption {
            return entries.firstOrNull { it.value == value } ?: Default
        }
    }
}

enum class LanguageOption(
    val code: String,
    val displayName: String
) {
    SYSTEM("system", "System default"),
    Arabic("ar", "Arabic"),
    Dutch("nl", "Dutch"),
    English("en", "English"),
    Estonian("et", "Estonian"),
    French("fr", "French"),
    German("de", "German"),
    Italian("it", "Italian"),
    Portuguese("pt", "Portuguese"),
    Spanish("es", "Spanish"),
    Thai("th", "Thai"),
    Turkish("tr", "Turkish");

    companion object {
        fun fromCode(code: String?): LanguageOption {
            return entries.firstOrNull { it.code == code } ?: SYSTEM
        }
    }
}

enum class BottomNavItem(
    @param:StringRes val label: Int,
    val icon: ImageVector,
    val route: String
) {
    Home(
        R.string.bottom_nav_home,
        Icons.Filled.Home,
        "home_main"
    ),
    Search(
        R.string.bottom_nav_search,
        Icons.Filled.Search,
        "search_screen"
    ),
    Settings(
        R.string.bottom_nav_settings,
        Icons.Filled.Settings,
        "settings_home"
    )
}