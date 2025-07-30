package com.kaleedtc.privacium.ui.theme.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kaleedtc.privacium.R
import com.kaleedtc.privacium.data.SettingItem
import com.kaleedtc.privacium.ui.theme.components.SettingListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    onShowThemeSelection: () -> Unit,
    onShowLanguageSelection: () -> Unit,
    onShowAbout: () -> Unit,
    onShowStartupCategorySelection: () -> Unit,
    onBack: () -> Unit,
) {
    val settingCategories = listOf(
        SettingItem(
            title = stringResource(R.string.theme_setting_title),
            icon = Icons.Filled.Palette,
            onClick = onShowThemeSelection
        ),
        SettingItem(
            title = stringResource(R.string.language_setting_title),
            icon = Icons.Filled.Language,
            onClick = onShowLanguageSelection
        ),
        SettingItem(
            title = stringResource(R.string.choose_startup_category),
            icon = Icons.Filled.Home,
            onClick = onShowStartupCategorySelection
        ),
        SettingItem(
            title = stringResource(R.string.about_setting_title),
            icon = Icons.Filled.Info,
            onClick = onShowAbout
        )
    )

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
                title = {
                    Text(stringResource(R.string.settings_title))
                },
                scrollBehavior = scrollBehavior,
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back_button_content_description)
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            items(settingCategories) { item ->
                SettingListItem(item = item) {
                    item.onClick()
                }
            }
        }
    }
}