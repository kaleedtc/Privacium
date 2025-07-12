package com.kaleedtc.privacium

import android.content.Context
import android.os.Bundle
import android.util.LayoutDirection
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.core.os.LocaleListCompat
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.kaleedtc.privacium.data.LANGUAGE_KEY
import com.kaleedtc.privacium.data.LanguageOption
import com.kaleedtc.privacium.data.THEME_KEY
import com.kaleedtc.privacium.data.ThemeOption
import com.kaleedtc.privacium.data.dataStore
import com.kaleedtc.privacium.data.provider.ToolRegistry
import com.kaleedtc.privacium.ui.theme.SevenTheme
import com.kaleedtc.privacium.ui.theme.screens.MainScreen
import com.kaleedtc.privacium.utils.createLocalizedContext
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.util.Locale

class MainActivity : ComponentActivity() {

    companion object {
        lateinit var activityDataStore: DataStore<Preferences>
    }

    override fun attachBaseContext(newBase: Context) {
        val sharedPrefs = newBase.getSharedPreferences("app_prefs", MODE_PRIVATE)
        val currentLanguageCode =
            sharedPrefs.getString("app_language_sync", LanguageOption.SYSTEM.code)
        val localizedContext = newBase.createLocalizedContext(currentLanguageCode)
        super.attachBaseContext(localizedContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        activityDataStore = dataStore
        ToolRegistry.initialize(this)

        // Create a state that collects the current theme option from DataStore.
        val themeOptionState = mutableStateOf(ThemeOption.Default)
        val languageOptionState = mutableStateOf(LanguageOption.SYSTEM)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                dataStore.data.map { prefs ->
                    val theme = ThemeOption.fromValue(prefs[THEME_KEY] ?: ThemeOption.Default.value)
                    val lang = LanguageOption.fromCode(prefs[LANGUAGE_KEY])
                    theme to lang
                }.collect { (themeOption, language) ->
                    themeOptionState.value = themeOption
                    languageOptionState.value = language

                    val appLocales = AppCompatDelegate.getApplicationLocales()
                    val currentLanguageCode = if (appLocales.isEmpty) {
                        LanguageOption.SYSTEM.code
                    } else {
                        appLocales.get(0)?.language ?: LanguageOption.SYSTEM.code
                    }

                    if (currentLanguageCode != language.code) {
                        val localeList = if (language.code == LanguageOption.SYSTEM.code) {
                            LocaleListCompat.getEmptyLocaleList()
                        } else {
                            LocaleListCompat.create(Locale.forLanguageTag(language.code))
                        }
                        AppCompatDelegate.setApplicationLocales(localeList)
                    }
                }
            }
        }

        setContent {
            val currentThemeOption = themeOptionState.value
            val currentLanguage = languageOptionState.value
            val context = LocalContext.current
            // To ensures Composables get the right resources and layout direction.
            val localizedContext = remember(currentLanguage.code) {
                context.createLocalizedContext(currentLanguage.code)
            }
            val layoutDirection = remember(localizedContext) {
                if (localizedContext.resources.configuration.layoutDirection == LayoutDirection.RTL) {
                    androidx.compose.ui.unit.LayoutDirection.Rtl
                } else {
                    androidx.compose.ui.unit.LayoutDirection.Ltr
                }
            }

            CompositionLocalProvider(
                LocalContext provides localizedContext,
                LocalLayoutDirection provides layoutDirection
            ) {
                SevenTheme(themeOption = currentThemeOption) {
                    MainScreen(
                        dataStore = this.dataStore, activity = this
                    )
                }
            }
        }
    }
}