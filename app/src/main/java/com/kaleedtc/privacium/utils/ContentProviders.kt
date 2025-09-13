package com.kaleedtc.privacium.utils

import android.content.Context
import com.kaleedtc.privacium.data.CategoryTool
import com.kaleedtc.privacium.data.Tool
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AlternateEmail
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Cable
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.filled.CleaningServices
import androidx.compose.material.icons.filled.CloudUpload
import androidx.compose.material.icons.filled.ContentPaste
import androidx.compose.material.icons.filled.CurrencyBitcoin
import androidx.compose.material.icons.filled.Devices
import androidx.compose.material.icons.filled.Dns
import androidx.compose.material.icons.filled.Domain
import androidx.compose.material.icons.filled.DriveFileRenameOutline
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.EnhancedEncryption
import androidx.compose.material.icons.filled.Extension
import androidx.compose.material.icons.filled.FileCopy
import androidx.compose.material.icons.filled.HealthAndSafety
import androidx.compose.material.icons.filled.InstallDesktop
import androidx.compose.material.icons.filled.InstallMobile
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LaptopMac
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.MarkUnreadChatAlt
import androidx.compose.material.icons.filled.NoteAlt
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.Photo
import androidx.compose.material.icons.filled.PrivacyTip
import androidx.compose.material.icons.filled.RemoveDone
import androidx.compose.material.icons.filled.Router
import androidx.compose.material.icons.filled.RssFeed
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.SocialDistance
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material.icons.filled.VpnLock
import androidx.compose.material.icons.filled.Web
import com.kaleedtc.privacium.R
import com.kaleedtc.privacium.data.provider.ToolRegistry

fun getCategories(context: Context): List<CategoryTool> {
    return listOf(
        CategoryTool(
            name = context.getString(R.string.internet_browsing),
            subCategories = listOf(
                context.getString(R.string.desktop_browsers),
                context.getString(R.string.mobile_browsers),
                context.getString(R.string.browser_extensions),
                context.getString(R.string.torbrowser)
            ),
            subCategoryIcons = listOf(
                Icons.Filled.InstallDesktop,
                Icons.Filled.InstallMobile,
                Icons.Filled.Extension,
                Icons.Filled.PrivacyTip
            )
        ),
        CategoryTool(
            name = context.getString(R.string.operating_systems),
            subCategories = listOf(
                context.getString(R.string.desktop),
                context.getString(R.string.android),
                context.getString(R.string.router_firmware)
            ),
            subCategoryIcons = listOf(
                Icons.Filled.LaptopMac,
                Icons.Filled.Android,
                Icons.Filled.Router
            )
        ),
        CategoryTool(
            name = context.getString(R.string.software),
            subCategories = listOf(
                context.getString(R.string.ai_chat),
                context.getString(R.string.password_managers),
                context.getString(R.string.multifactor_authentication),
                context.getString(R.string.email_clients),
                context.getString(R.string.calendar),
                context.getString(R.string.office_suites),
                context.getString(R.string.notebooks),
                context.getString(R.string.cryptocurrency),
                context.getString(R.string.file_sharing),
                context.getString(R.string.metadata),
                context.getString(R.string.document_collaboration),
                context.getString(R.string.encryption),
                context.getString(R.string.frontends),
                context.getString(R.string.health),
                context.getString(R.string.language_tools),
                context.getString(R.string.maps),
                context.getString(R.string.news_aggregators),
                context.getString(R.string.pastebins),
                context.getString(R.string.real_time_communication),
                context.getString(R.string.social_networks)
            ),
            subCategoryIcons = listOf(
                Icons.Filled.ChatBubbleOutline,
                Icons.Filled.Password,
                Icons.Filled.Security,
                Icons.Filled.Email,
                Icons.Filled.CalendarMonth,
                Icons.Filled.FileCopy,
                Icons.Filled.NoteAlt,
                Icons.Filled.CurrencyBitcoin,
                Icons.Filled.Share,
                Icons.Filled.RemoveDone,
                Icons.Filled.DriveFileRenameOutline,
                Icons.Filled.EnhancedEncryption,
                Icons.Filled.Web,
                Icons.Filled.HealthAndSafety,
                Icons.Filled.Language,
                Icons.Filled.Map,
                Icons.Filled.RssFeed,
                Icons.Filled.ContentPaste,
                Icons.Filled.MarkUnreadChatAlt,
                Icons.Filled.People
            )
        ),
        CategoryTool(
            name = context.getString(R.string.providers),
            subCategories = listOf(
                context.getString(R.string.cloud_storage),
                context.getString(R.string.data_removal_services),
                context.getString(R.string.dns_resolvers),
                context.getString(R.string.email_aliasing),
                context.getString(R.string.email_services),
                context.getString(R.string.financial_services),
                context.getString(R.string.photo_management),
                context.getString(R.string.search_engines),
                context.getString(R.string.vpn_services)
            ),
            subCategoryIcons = listOf(
                Icons.Filled.CloudUpload,
                Icons.Filled.CleaningServices,
                Icons.Filled.Dns,
                Icons.Filled.AlternateEmail,
                Icons.Filled.Mail,
                Icons.Filled.AttachMoney,
                Icons.Filled.Photo,
                Icons.Filled.Search,
                Icons.Filled.VpnLock
            )
        ),
        CategoryTool(
            name = context.getString(R.string.hardware),
            subCategories = listOf(
                context.getString(R.string.mobile_phones),
                context.getString(R.string.security_keys)
            ),
            subCategoryIcons = listOf(
                Icons.Filled.PhoneAndroid,
                Icons.Filled.Key
            )
        ),
        CategoryTool(
            name = context.getString(R.string.advanced),
            subCategories = listOf(
                context.getString(R.string.alternative_networks),
                context.getString(R.string.device_integrity)
            ),
            subCategoryIcons = listOf(
                Icons.Filled.Cable,
                Icons.Filled.Devices
            )
        ),
        CategoryTool(
            name = context.getString(R.string.self_hosting),
            subCategories = listOf(
                context.getString(R.string.email_servers),
                context.getString(R.string.socialnetworks),
                context.getString(R.string.frontend),
                context.getString(R.string.dns_filtering),
                context.getString(R.string.password_management)
            ),
            subCategoryIcons = listOf(
                Icons.Filled.Storage,
                Icons.Filled.SocialDistance,
                Icons.Filled.Domain,
                Icons.Filled.Dns,
                Icons.Filled.Password
            )
        )
    )
}

fun getToolsForSubCategory(context: Context, subCategoryName: String): List<Tool> {
    return ToolRegistry.getTools(context, subCategoryName)
}

fun getAllTools(context: Context): List<Tool> {
    return ToolRegistry.getAllTools(context)
}

fun getToolsForCategory(context: Context, category: CategoryTool): List<Tool> {
    return category.subCategories.flatMap { subCategoryName ->
        getToolsForSubCategory(context, subCategoryName)
    }.distinct()
}