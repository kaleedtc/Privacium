package com.kaleedtc.privacium.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

// Data model for PrivacyTools
data class CategoryTool(
    val name: String,
    val subCategories: List<String> = emptyList(),
    val subCategoryIcons: List<ImageVector> = emptyList()
)

// Data model for Tools
data class Tool(
    val title: String,
    val description: String,
    @param:DrawableRes val icon: Int,
    val homepage: String? = null
)

data class SettingItem(
    val title: String,
    val icon: ImageVector,
    val onClick: () -> Unit
)