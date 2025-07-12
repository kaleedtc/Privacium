package com.kaleedtc.privacium.ui.theme.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kaleedtc.privacium.R
import com.kaleedtc.privacium.data.CategoryTool
import com.kaleedtc.privacium.ui.theme.components.PrivacyTools
import com.kaleedtc.privacium.ui.theme.components.SubCategoryTool

@Composable
fun HomeMainContent(
    selectedCategory: CategoryTool,
    orderedCategories: List<CategoryTool>,
    lazyListState: LazyListState,
    onCategorySelected: (CategoryTool) -> Unit,
    onSubCategoryClick: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        if (orderedCategories.isNotEmpty()) {
            LazyRow(
                state = lazyListState,
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(horizontal = 8.dp)
            ) {
                items(orderedCategories) { category ->
                    PrivacyTools(
                        category = category,
                        isSelected = category.name == selectedCategory.name,
                        onClick = { onCategorySelected(category) }
                    )
                }
            }
        } else {
            Text(stringResource(R.string.no_categories_to_display))
        }

        if (selectedCategory.subCategories.isEmpty()) {
            Text(stringResource(R.string.no_sub_categories_for, selectedCategory.name))
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                itemsIndexed(selectedCategory.subCategories) { index, subCategoryName ->
                    SubCategoryTool(
                        subCategoryName = subCategoryName,
                        subCategoryIcon = selectedCategory.subCategoryIcons.getOrElse(index) { Icons.Default.BrokenImage },
                        onSubCategoryClick = { onSubCategoryClick(subCategoryName) }
                    )
                }
            }
        }
    }
}