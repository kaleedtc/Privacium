package com.kaleedtc.privacium.ui.theme.screens

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kaleedtc.privacium.R
import com.kaleedtc.privacium.data.BottomNavItem
import com.kaleedtc.privacium.data.STARTUP_CATEGORY_KEY
import com.kaleedtc.privacium.ui.theme.screens.home.HomeMainContent
import com.kaleedtc.privacium.ui.theme.screens.home.ToolsForSubCategoryScreen
import com.kaleedtc.privacium.ui.theme.screens.search.SearchScreen
import com.kaleedtc.privacium.ui.theme.screens.settings.AboutScreen
import com.kaleedtc.privacium.ui.theme.screens.settings.LanguageSelectionScreen
import com.kaleedtc.privacium.ui.theme.screens.settings.SettingsScreen
import com.kaleedtc.privacium.ui.theme.screens.settings.StartupCategorySelectionScreen
import com.kaleedtc.privacium.ui.theme.screens.settings.ThemeSelectionScreen
import com.kaleedtc.privacium.utils.getCategories
import kotlinx.coroutines.flow.map

@Composable
fun MainScreen(
    dataStore: DataStore<Preferences>,
    activity: ComponentActivity
) {
    val context = LocalContext.current
    val categories = remember { getCategories(context) }

    var selectedCategory by remember { mutableStateOf(categories.first()) }

    LaunchedEffect(Unit) {
        dataStore.data.map { preferences ->
            preferences[STARTUP_CATEGORY_KEY]
        }.collect { startupCategoryName ->
            selectedCategory = categories.find { it.name == startupCategoryName }
                ?: categories.find { it.name == context.getString(R.string.software) }
                        ?: categories.first()
        }
    }

    // To Ensure orderedCategories and lazyListState are defined if used in HomeMainContent
    val orderedCategories = remember(selectedCategory, categories) {
        selectedCategory.let { cat ->
            val selectedIndex = categories.indexOfFirst { it.name == cat.name }
            if (selectedIndex == -1) {
                categories
            } else {
                categories.drop(selectedIndex) + categories.take(selectedIndex)
            }
        }
    }
    val lazyListState = rememberLazyListState()
    LaunchedEffect(selectedCategory) {
        lazyListState.animateScrollToItem(0)
    }

    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        bottomBar = {
            NavigationBar {
                BottomNavItem.entries.forEach { item ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = stringResource(id = item.label)
                            )
                        },
                        label = { Text(text = stringResource(id = item.label)) },
                        selected = item.route == currentBackStackEntry?.destination?.route,
                        onClick = {
                            if (item.route != currentBackStackEntry?.destination?.route) {
                                navController.navigate(item.route) {
                                    popUpTo(BottomNavItem.Home.route) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = false
                                }
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = innerPadding.calculateStartPadding(LocalLayoutDirection.current),
                    end = innerPadding.calculateEndPadding(LocalLayoutDirection.current),
                    bottom = innerPadding.calculateBottomPadding()
                )
        ) {
            composable(BottomNavItem.Home.route) {
                HomeMainContent(
                    selectedCategory = selectedCategory,
                    orderedCategories = orderedCategories,
                    lazyListState = lazyListState,
                    onCategorySelected = { category -> selectedCategory = category },
                    onSubCategoryClick = { subCategoryName ->
                        navController.navigate("tools_for_subcategory/$subCategoryName")
                    }
                )
            }
            composable(
                route = "tools_for_subcategory/{subCategoryName}",
                arguments = listOf(navArgument("subCategoryName") {
                    type = NavType.StringType
                })
            ) { backStackEntry ->
                val subCategoryName =
                    backStackEntry.arguments?.getString("subCategoryName")
                if (subCategoryName != null) {
                    ToolsForSubCategoryScreen(
                        subCategoryName = subCategoryName,
                        onBack = { navController.popBackStack() },
                    )
                } else {
                    Text(stringResource(R.string.error_sub_category_not_found))
                    // Optionally navigate back if argument is missing
                    LaunchedEffect(Unit) { navController.popBackStack() }
                }
            }
            composable(BottomNavItem.Settings.route) {
                SettingsScreen(
                    onShowThemeSelection = { navController.navigate("theme_selection") },
                    onShowLanguageSelection = { navController.navigate("language_selection") },
                    onShowStartupCategorySelection = { navController.navigate("startup_category_selection") },
                    onShowAbout = { navController.navigate("about_screen") },
                    onBack = {
                        navController.navigate(BottomNavItem.Home.route) {
                            popUpTo(navController.graph.startDestinationId)
                        }
                    }
                )
            }
            composable("theme_selection") {
                ThemeSelectionScreen(dataStore = dataStore) {
                    navController.popBackStack()
                }
            }
            composable("language_selection") {
                LanguageSelectionScreen(dataStore = dataStore, activity = activity) {
                    navController.popBackStack()
                }
            }
            composable("about_screen") {
                AboutScreen {
                    navController.popBackStack()
                }
            }
            composable("startup_category_selection") {
                StartupCategorySelectionScreen(dataStore = dataStore) {
                    navController.popBackStack()
                }
            }
            composable("search_screen") {
                SearchScreen {
                    navController.navigate(BottomNavItem.Home.route) {
                        popUpTo(navController.graph.startDestinationId)
                    }
                }
            }
        }
    }
}