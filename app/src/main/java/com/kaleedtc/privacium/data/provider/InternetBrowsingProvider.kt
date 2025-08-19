
package com.kaleedtc.privacium.data.provider

import android.content.Context
import com.kaleedtc.privacium.R
import com.kaleedtc.privacium.data.Tool

fun getDesktopBrowsersTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.brave_browser),
            description = context.getString(R.string.brave_description),
            icon = R.drawable.brave,
            homepage = context.getString(R.string.brave_page),
        ),
        Tool(
            title = context.getString(R.string.firefox),
            description = context.getString(R.string.firefox_description),
            icon = R.drawable.firefox,
            homepage = context.getString(R.string.firefox_page)
        ),
        Tool(
            title = context.getString(R.string.mullvad_browser),
            description = context.getString(R.string.mullvad_browser_description),
            icon = R.drawable.mullvad_browser,
            homepage = context.getString(R.string.mullvad_browser_page)
        )
    )
}

fun getMobileBrowsersTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.brave_browser),
            description = context.getString(R.string.brave_description),
            icon = R.drawable.brave,
            homepage = context.getString(R.string.brave_page),
        ),
        Tool(
            title = context.getString(R.string.cromite),
            description = context.getString(R.string.cromite_description),
            icon = R.drawable.cromite,
            homepage = context.getString(R.string.cromite_page)
        ),
        Tool(
            title = context.getString(R.string.safari),
            description = context.getString(R.string.safari_description),
            icon = R.drawable.safari_ios,
            homepage = context.getString(R.string.safari_page)
        )
    )
}

fun getBrowserExtensionsTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.ublock_origin),
            description = context.getString(R.string.ublock_origin_description),
            icon = R.drawable.ublock_origin,
            homepage = context.getString(R.string.ublock_page)
        ),
        Tool(
            title = context.getString(R.string.ublock_origin_lite),
            description = context.getString(R.string.ublock_origin_lite_description),
            icon = R.drawable.ublock_origin_lite,
            homepage = context.getString(R.string.ubol_page)
        ),
        Tool(
            title = context.getString(R.string.adguard),
            description = context.getString(R.string.adguard_description),
            icon = R.drawable.adguard,
            homepage = context.getString(R.string.adguard_ios_page)
        ),
        Tool(
            title = context.getString(R.string.privacy_badger),
            description = context.getString(R.string.privacy_badger_description),
            icon = R.drawable.eff,
            homepage = context.getString(R.string.privacy_badger_page)
        ),
        Tool(
            title = context.getString(R.string.snowflake),
            description = context.getString(R.string.snowflake_extension_description),
            icon = R.drawable.snowflake,
            homepage = context.getString(R.string.snowflake_extension_page)
        )
    )
}

fun getTorBrowserTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.tor_browser),
            description = context.getString(R.string.tor_browser_description),
            icon = R.drawable.tor,
            homepage = context.getString(R.string.torproject_page)
        ),
        Tool(
            title = context.getString(R.string.onion_browser),
            description = context.getString(R.string.onion_browser_description),
            icon = R.drawable.onion_browser,
            homepage = context.getString(R.string.onionbrowser_page)
        )
    )
}
