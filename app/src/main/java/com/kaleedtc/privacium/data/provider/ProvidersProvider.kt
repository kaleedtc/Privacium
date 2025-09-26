package com.kaleedtc.privacium.data.provider

import android.content.Context
import com.kaleedtc.privacium.R
import com.kaleedtc.privacium.data.Tool

fun getCloudStorageTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.protondrive),
            description = context.getString(R.string.protondrive_description),
            icon = R.drawable.protondrive,
            homepage = context.getString(R.string.protondrive_page)
        ),
        Tool(
            title = context.getString(R.string.tresorit),
            description = context.getString(R.string.tresorit_description),
            icon = R.drawable.tresorit,
            homepage = context.getString(R.string.tresorit_page)
        ),
        Tool(
            title = context.getString(R.string.peergos),
            description = context.getString(R.string.peergos_description),
            icon = R.drawable.peergos,
            homepage = context.getString(R.string.peergos_page)
        )
    )
}

fun getDataRemovalServicesTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.easyoptouts),
            description = context.getString(R.string.easyoptouts_description),
            icon = R.drawable.easyoptouts,
            homepage = context.getString(R.string.easyoptouts_page)
        ),
        Tool(
            title = context.getString(R.string.results_about_you),
            description = context.getString(R.string.results_about_you_description),
            icon = R.drawable.google,
            homepage = context.getString(R.string.results_about_you_page)
        )
    )
}

fun getDnsResolversTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.controld),
            description = context.getString(R.string.controld_description),
            icon = R.drawable.control_d,
            homepage = context.getString(R.string.controld_page)
        ),
        Tool(
            title = context.getString(R.string.cloudflare),
            description = context.getString(R.string.cloudflare_description),
            icon = R.drawable.cloudflare,
            homepage = context.getString(R.string.cloudflare_page)
        ),
        Tool(
            title = context.getString(R.string.quad9),
            description = context.getString(R.string.quad9_description),
            icon = R.drawable.quad9,
            homepage = context.getString(R.string.quad9_page)
        ),
        Tool(
            title = context.getString(R.string.mullvad),
            description = context.getString(R.string.mullvad_description),
            icon = R.drawable.mullvad,
            homepage = context.getString(R.string.mullvad_page)
        ),
        Tool(
            title = context.getString(R.string.adguard),
            description = context.getString(R.string.adguard_dns_description),
            icon = R.drawable.adguard,
            homepage = context.getString(R.string.adguard_dns_page)
        ),
        Tool(
            title = context.getString(R.string.dns0_eu),
            description = context.getString(R.string.dns0_eu_description),
            icon = R.drawable.dns0,
            homepage = context.getString(R.string.dns0_eu_page)
        ),
        Tool(
            title = context.getString(R.string.rethinkdns),
            description = context.getString(R.string.rethinkdns_description),
            icon = R.drawable.rethinkdns,
            homepage = context.getString(R.string.rethinkdns_page)
        ),
        Tool(
            title = context.getString(R.string.dnscrypt_proxy),
            description = context.getString(R.string.dnscrypt_proxy_description),
            icon = R.drawable.dnscrypt_proxy,
            homepage = context.getString(R.string.dnscrypt_proxy_page)
        ),
        Tool(
            title = context.getString(R.string.nextdns),
            description = context.getString(R.string.nextdns_description),
            icon = R.drawable.nextdns,
            homepage = context.getString(R.string.nextdns_page)
        )
    )
}

fun getEmailAliasingTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.addy_io),
            description = context.getString(R.string.addy_io_description),
            icon = R.drawable.addy,
            homepage = context.getString(R.string.addy_io_page)
        ),
        Tool(
            title = context.getString(R.string.simplelogin),
            description = context.getString(R.string.simplelogin_description),
            icon = R.drawable.simplelogin,
            homepage = context.getString(R.string.simplelogin_page)
        )
    )
}

fun getEmailServicesTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.protonmail),
            description = context.getString(R.string.protonmail_description),
            icon = R.drawable.protonmail,
            homepage = context.getString(R.string.protonmail_page)
        ),
        Tool(
            title = context.getString(R.string.mailbox_org),
            description = context.getString(R.string.mailbox_org_description),
            icon = R.drawable.mailboxorg,
            homepage = context.getString(R.string.mailbox_org_page)
        ),
        Tool(
            title = context.getString(R.string.tuta),
            description = context.getString(R.string.tuta_email_description),
            icon = R.drawable.tuta,
            homepage = context.getString(R.string.tuta_page)
        )
    )
}

fun getFinancialServicesTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.privacy_com),
            description = context.getString(R.string.privacy_com_description),
            icon = R.drawable.privacy_com,
            homepage = context.getString(R.string.privacy_com_page)
        ),
        Tool(
            title = context.getString(R.string.mysudo),
            description = context.getString(R.string.mysudo_description),
            icon = R.drawable.mysudo,
            homepage = context.getString(R.string.mysudo_page)
        ),
        Tool(
            title = context.getString(R.string.coincards),
            description = context.getString(R.string.coincards_description),
            icon = R.drawable.coincards,
            homepage = context.getString(R.string.coincards_page)
        )
    )
}

fun getPhotoManagementTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.ente_photos),
            description = context.getString(R.string.ente_photos_description),
            icon = R.drawable.ente,
            homepage = context.getString(R.string.ente_page)
        )
    )
}

fun getSearchEnginesTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.brave_search),
            description = context.getString(R.string.brave_search_description),
            icon = R.drawable.brave_search,
            homepage = context.getString(R.string.brave_search_page)
        ),
        Tool(
            title = context.getString(R.string.duckduckgo),
            description = context.getString(R.string.duckduckgo_description),
            icon = R.drawable.duckduckgo,
            homepage = context.getString(R.string.duckduckgo_page)
        ),
        Tool(
            title = context.getString(R.string.mullvad_leta),
            description = context.getString(R.string.mullvad_leta_description),
            icon = R.drawable.mullvad,
            homepage = context.getString(R.string.mullvad_leta_page)
        ),
        Tool(
            title = context.getString(R.string.startpage),
            description = context.getString(R.string.startpage_description),
            icon = R.drawable.startpage,
            homepage = context.getString(R.string.startpage_page)
        ),
        Tool(
            title = context.getString(R.string.searxng),
            description = context.getString(R.string.searxng_description),
            icon = R.drawable.searxng,
            homepage = context.getString(R.string.searxng_page)
        )
    )
}

fun getVpnServicesTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.protonvpn),
            description = context.getString(R.string.protonvpn_description),
            icon = R.drawable.protonvpn,
            homepage = context.getString(R.string.protonvpn_page)
        ),
        Tool(
            title = context.getString(R.string.ivpn),
            description = context.getString(R.string.ivpn_description),
            icon = R.drawable.ivpn,
            homepage = context.getString(R.string.ivpn_page)
        ),
        Tool(
            title = context.getString(R.string.mullvad),
            description = context.getString(R.string.mullvadvpn_description),
            icon = R.drawable.mullvad,
            homepage = context.getString(R.string.mullvadvpn_page)
        )
    )
}