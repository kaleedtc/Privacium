package com.kaleedtc.privacium.utils

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import com.kaleedtc.privacium.data.LanguageOption
import java.util.Locale

fun Context.createLocalizedContext(languageCode: String?): Context {
    if (languageCode == null || languageCode == LanguageOption.SYSTEM.code) {
        // Use system locale or remove app-specific override
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.getEmptyLocaleList())
        return this
    }
    val locale = Locale.forLanguageTag(languageCode)
    Locale.setDefault(locale)

    // For Android N (API 24) and above, setApplicationLocales is preferred
    val localeList = LocaleListCompat.create(locale)
    AppCompatDelegate.setApplicationLocales(localeList)

    // For older versions or as a fallback, manually update configuration
    val configuration = Configuration(resources.configuration)
    configuration.setLocale(locale)
    configuration.setLayoutDirection(locale)
    return createConfigurationContext(configuration)
}