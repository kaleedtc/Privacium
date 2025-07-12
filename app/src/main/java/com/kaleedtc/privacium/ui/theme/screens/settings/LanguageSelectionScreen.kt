package com.kaleedtc.privacium.ui.theme.screens.settings

import android.app.Activity
import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.kaleedtc.privacium.R
import com.kaleedtc.privacium.data.LANGUAGE_KEY
import com.kaleedtc.privacium.data.LanguageOption
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageSelectionScreen(
    dataStore: DataStore<Preferences>,
    activity: Activity,
    onBack: () -> Unit
) {
    val scope = rememberCoroutineScope()
    var selectedLanguageOption by remember { mutableStateOf(LanguageOption.SYSTEM) }

    LaunchedEffect(Unit) {
        dataStore.data
            .map { preferences ->
                LanguageOption.fromCode(preferences[LANGUAGE_KEY])
            }
            .collect { language ->
                selectedLanguageOption = language
            }
    }
    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(
            rememberTopAppBarState(),
            canScroll = { true },
        )
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MediumTopAppBar(
                title = { Text(stringResource(R.string.choose_language_title)) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back_button)
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            LanguageOption.entries.forEach { option ->
                item {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = (selectedLanguageOption == option),
                                onClick = {
                                    if (selectedLanguageOption != option) {
                                        selectedLanguageOption = option
                                        scope.launch {
                                            dataStore.edit { preferences ->
                                                preferences[LANGUAGE_KEY] = option.code

                                                val sharedPrefs = activity.getSharedPreferences(
                                                    "app_prefs",
                                                    Context.MODE_PRIVATE
                                                )
                                                with(sharedPrefs.edit()) {
                                                    putString("app_language_sync", option.code)
                                                    apply()
                                                }
                                            }
                                            activity.recreate()
                                        }
                                    }
                                }
                            )
                            .padding(vertical = 8.dp)
                    ) {
                        RadioButton(
                            selected = selectedLanguageOption == option,
                            onClick = null
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = option.displayName)
                    }
                }
            }
        }
    }
}