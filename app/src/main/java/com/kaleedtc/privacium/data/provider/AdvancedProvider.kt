
package com.kaleedtc.privacium.data.provider

import android.content.Context
import com.kaleedtc.privacium.R
import com.kaleedtc.privacium.data.Tool

fun getAdvancedTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.tornetwork),
            description = context.getString(R.string.tornetwork_description),
            icon = R.drawable.tor,
            homepage = context.getString(R.string.tornetwork_page)
        ),
        Tool(
            title = context.getString(R.string.orbot),
            description = context.getString(R.string.orbot_description),
            icon = R.drawable.orbot,
            homepage = context.getString(R.string.orbot_page)
        ),
        Tool(
            title = context.getString(R.string.snowflake),
            description = context.getString(R.string.snowflake_description),
            icon = R.drawable.snowflake,
            homepage = context.getString(R.string.snowflake_page)
        ),
        Tool(
            title = context.getString(R.string.i2p),
            description = context.getString(R.string.i2p_description),
            icon = R.drawable.i2p,
            homepage = context.getString(R.string.i2p_page)
        )
    )
}

fun getDeviceIntegrityTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.mvt),
            description = context.getString(R.string.mvt_description),
            icon = R.drawable.mvt,
            homepage = "https://mvt.re/"
        ),
        Tool(
            title = context.getString(R.string.imazing),
            description = context.getString(R.string.imazing_description),
            icon = R.drawable.imazing,
            homepage = context.getString(R.string.imazing_page)
        ),
        Tool(
            title = context.getString(R.string.auditor),
            description = context.getString(R.string.auditor_description),
            icon = R.drawable.auditor,
            homepage = context.getString(R.string.attestation_page)
        )
    )
}
