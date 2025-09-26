package com.kaleedtc.privacium.data.provider

import android.content.Context
import com.kaleedtc.privacium.R
import com.kaleedtc.privacium.data.Tool

fun getEmailServersTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.stalwart),
            description = context.getString(R.string.stalwart_description),
            icon = R.drawable.stalwart,
            homepage = context.getString(R.string.stalwart_page)
        ),
        Tool(
            title = context.getString(R.string.mailcow),
            description = context.getString(R.string.mailcow_description),
            icon = R.drawable.mailcow,
            homepage = context.getString(R.string.mailcow_page)
        ),
        Tool(
            title = context.getString(R.string.mailinabox),
            description = context.getString(R.string.mailinabox_description),
            icon = R.drawable.mail_in_a_box,
            homepage = context.getString(R.string.mailinabox_page)
        )
    )
}

fun getDnsFilteringTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.pi_hole),
            description = context.getString(R.string.pihole_description),
            icon = R.drawable.pi_hole,
            homepage = context.getString(R.string.pihole_page)
        ),
        Tool(
            title = context.getString(R.string.adguard_home),
            description = context.getString(R.string.adguard_home_description),
            icon = R.drawable.adguard,
            homepage = context.getString(R.string.adguard_home_page)
        )
    )
}

fun getPasswordManagementTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.vaultwarden),
            description = context.getString(R.string.vaultwarden_description),
            icon = R.drawable.vaultwarden,
            homepage = context.getString(R.string.vaultwarden_page)
        )
    )
}

fun getFileManagementTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.photoprism),
            description = context.getString(R.string.photoprism_description),
            icon = R.drawable.photoprism,
            homepage = context.getString(R.string.photoprism_page)
        ),
        Tool(
            title = context.getString(R.string.freedombox),
            description = context.getString(R.string.freedombox_description),
            icon = R.drawable.freedombox,
            homepage = context.getString(R.string.freedombox_page)
        ),
        Tool(
            title = context.getString(R.string.nextcloud),
            description = context.getString(R.string.nextcloud_description),
            icon = R.drawable.nextcloud,
            homepage = context.getString(R.string.nextcloud_page)
        )
    )
}

fun getFrontendTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.redlib),
            description = context.getString(R.string.redlib_description),
            icon = R.drawable.redlib,
            homepage = context.getString(R.string.redlib_page)
        ),
        Tool(
            title = context.getString(R.string.proxitok),
            description = context.getString(R.string.proxitok_description),
            icon = R.drawable.proxitok,
            homepage = context.getString(R.string.proxitok_page)
        ),
        Tool(
            title = context.getString(R.string.invidious),
            description = context.getString(R.string.invidious_description),
            icon = R.drawable.invidious,
            homepage = context.getString(R.string.invidious_page)
        ),
        Tool(
            title = context.getString(R.string.piped),
            description = context.getString(R.string.piped_description),
            icon = R.drawable.piped,
            homepage = context.getString(R.string.piped_page)
        )
    )
}