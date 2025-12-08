package com.kaleedtc.privacium.ui.theme.screens.settings.customization

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.kaleedtc.privacium.R
import com.kaleedtc.privacium.data.SHOW_EXIT_DIALOG_KEY
import com.kaleedtc.privacium.data.SettingItem
import com.kaleedtc.privacium.ui.theme.components.SettingListItem
import com.kaleedtc.privacium.ui.theme.components.SwitchSettingListItem
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomizationScreen(
    dataStore: DataStore<Preferences>,
    onShowStartupCategorySelection: () -> Unit,
    onBack: () -> Unit,
) {
    val scope = rememberCoroutineScope()
    val preferences by dataStore.data.collectAsState(initial = null)
    val showExitDialog = preferences?.get(SHOW_EXIT_DIALOG_KEY) ?: true

    val settingCategories = listOf(
        SettingItem(
            title = stringResource(R.string.choose_startup_category),
            icon = Icons.Filled.Home,
            onClick = onShowStartupCategorySelection
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
                    Text(stringResource(R.string.customization))
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
            item {
                Spacer(modifier = Modifier.height(8.dp))
            }
            item {
                SwitchSettingListItem(
                    item = SettingItem(
                        title = stringResource(R.string.confirm_on_exit),
                        icon = Icons.Filled.CheckCircle,
                        onClick = {}
                    ),
                    checked = showExitDialog,
                    onCheckedChange = {
                        scope.launch {
                            dataStore.edit { settings ->
                                settings[SHOW_EXIT_DIALOG_KEY] = it
                            }
                        }
                    }
                )
            }
        }
    }
}