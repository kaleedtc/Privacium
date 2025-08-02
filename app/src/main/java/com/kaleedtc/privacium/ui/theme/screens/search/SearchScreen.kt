package com.kaleedtc.privacium.ui.theme.screens.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kaleedtc.privacium.R
import com.kaleedtc.privacium.data.CategoryTool
import com.kaleedtc.privacium.ui.theme.components.ToolsList
import com.kaleedtc.privacium.utils.getAllTools
import com.kaleedtc.privacium.utils.getCategories
import com.kaleedtc.privacium.utils.getToolsForCategory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    onBack: () -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    val context = LocalContext.current
    val allTools = remember { getAllTools(context) }
    val categories = remember { getCategories(context) }
    var selectedCategory by remember { mutableStateOf<CategoryTool?>(null) }
    var showCategoryMenu by remember { mutableStateOf(false) }

    val filteredTools = when {
        searchQuery.isBlank() -> emptyList()
        selectedCategory != null -> {
            val toolsForCategory = getToolsForCategory(context, selectedCategory!!)
            toolsForCategory.filter {
                it.title.contains(searchQuery, ignoreCase = true) ||
                        it.description.contains(searchQuery, ignoreCase = true)
            }
        }

        else -> allTools.filter {
            it.title.contains(searchQuery, ignoreCase = true) ||
                    it.description.contains(searchQuery, ignoreCase = true)
        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Box {
                        TextField(
                            value = searchQuery,
                            onValueChange = { searchQuery = it },
                            placeholder = {
                                Text(
                                    if (selectedCategory != null) stringResource(
                                        R.string.search_in,
                                        selectedCategory!!.name
                                    )
                                    else stringResource(R.string.search_for_tools)
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            leadingIcon = {
                                IconButton(onClick = { showCategoryMenu = true }) {
                                    Icon(
                                        imageVector = Icons.Default.FilterList,
                                        contentDescription = "Filter by category",
                                        tint = if (selectedCategory != null) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            },
                            trailingIcon = {
                                if (searchQuery.isNotEmpty()) {
                                    IconButton(onClick = { searchQuery = "" }) {
                                        Icon(
                                            imageVector = Icons.Default.Clear,
                                            contentDescription = "Clear search"
                                        )
                                    }
                                }
                            },
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent,
                            )
                        )
                        DropdownMenu(
                            expanded = showCategoryMenu,
                            onDismissRequest = { showCategoryMenu = false }
                        ) {
                            DropdownMenuItem(
                                text = {
                                    Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                                        RadioButton(
                                            selected = selectedCategory == null,
                                            onClick = null
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(stringResource(R.string.all))
                                    }
                                },
                                onClick = {
                                    selectedCategory = null
                                    showCategoryMenu = false
                                }
                            )
                            categories.forEach { category ->
                                DropdownMenuItem(
                                    text = {
                                        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                                            RadioButton(
                                                selected = selectedCategory?.name == category.name,
                                                onClick = null
                                            )
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Text(category.name)
                                        }
                                    },
                                    onClick = {
                                        selectedCategory = category
                                        showCategoryMenu = false
                                    }
                                )
                            }
                        }
                    }
                },
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
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            if (searchQuery.isNotBlank() && filteredTools.isEmpty()) {
                item {
                    Text(
                        text = stringResource(R.string.no_tools_found_for, searchQuery),
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            } else {
                items(filteredTools) { tool ->
                    ToolsList(tool = tool)
                }
            }
        }
    }
}
