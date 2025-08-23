package com.kaleedtc.privacium.data.provider

import android.content.Context
import com.kaleedtc.privacium.R
import com.kaleedtc.privacium.data.Tool

fun getMobilePhonesTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.googlepixel),
            description = context.getString(R.string.googlepixel_description),
            icon = R.drawable.mobile,
            homepage = context.getString(R.string.googlephones_page)
        )
    )
}

fun getSecurityKeysTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.yubikey),
            description = context.getString(R.string.yubikey_description),
            icon = R.drawable.yubico,
            homepage = context.getString(R.string.yubico_page)
        ),
        Tool(
            title = context.getString(R.string.nitrokey),
            description = context.getString(R.string.nitrokey_description),
            icon = R.drawable.nitrokey,
            homepage = context.getString(R.string.nitrokey_page)
        )
    )
}