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