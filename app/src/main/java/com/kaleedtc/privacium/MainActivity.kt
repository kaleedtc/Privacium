package com.kaleedtc.privacium

import android.content.Context
import android.os.Bundle
import android.util.LayoutDirection
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatDelegate
import androidx.activity.compose.BackHandler
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
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
import com.kaleedtc.privacium.data.SHOW_EXIT_DIALOG_KEY
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
            var showExitDialog by remember { mutableStateOf(false) }
            val preferences by dataStore.data.collectAsState(initial = null)
            val showExitDialogEnabled = preferences?.get(SHOW_EXIT_DIALOG_KEY) ?: true

            BackHandler(enabled = true) {
                if (showExitDialogEnabled) {
                    showExitDialog = true
                } else {
                    finish()
                }
            }

            CompositionLocalProvider(
                LocalContext provides localizedContext,
                LocalLayoutDirection provides layoutDirection
            ) {
                SevenTheme(themeOption = currentThemeOption) {
                    if (showExitDialog) {
                        AlertDialog(
                            onDismissRequest = { showExitDialog = false },
                            title = { Text(text = stringResource(id = R.string.confirm_exit_title)) },
                            text = { Text(text = stringResource(id = R.string.confirm_exit_message)) },
                            confirmButton = {
                                TextButton(onClick = { finish() }) {
                                    Text(text = stringResource(id = R.string.yes))
                                }
                            },
                            dismissButton = {
                                TextButton(onClick = { showExitDialog = false }) {
                                    Text(text = stringResource(id = R.string.no))
                                }
                            }
                        )
                    }
                    MainScreen(
                        dataStore = this.dataStore, activity = this
                    )
                }
            }
        }
    }
}