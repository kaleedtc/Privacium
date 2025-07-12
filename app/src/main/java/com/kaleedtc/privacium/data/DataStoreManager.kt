package com.kaleedtc.privacium.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

val THEME_KEY = stringPreferencesKey("theme_option")
val LANGUAGE_KEY = stringPreferencesKey("app_language")