package com.kaleedtc.privacium.ui.theme.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SubCategoryTool(
    subCategoryName: String,
    subCategoryIcon: ImageVector,
    onSubCategoryClick: (String) -> Unit
) {
    val cardBackgroundColor = MaterialTheme.colorScheme.surfaceContainerHigh

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(115.dp)
            .clickable { onSubCategoryClick(subCategoryName) },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = cardBackgroundColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                imageVector = subCategoryIcon,
                contentDescription = "Sub-category icon",
                modifier = Modifier.size(18.dp)
            )
            Text(
                text = subCategoryName,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp),
                textAlign = TextAlign.Start
            )
        }
    }
}