package com.kaleedtc.privacium.data.provider

import android.content.Context
import com.kaleedtc.privacium.R
import com.kaleedtc.privacium.data.Tool

fun getAiChatTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.kobold_cpp),
            description = context.getString(R.string.koboldcpp_description),
            icon = R.drawable.kobold,
            homepage = context.getString(R.string.koboldcpp_page)
        ),
        Tool(
            title = context.getString(R.string.ollama),
            description = context.getString(R.string.ollama_description),
            icon = R.drawable.ollama,
            homepage = context.getString(R.string.ollama_page)
        ),
        Tool(
            title = context.getString(R.string.llamafile),
            description = context.getString(R.string.llamafile_description),
            icon = R.drawable.llamafile,
            homepage = context.getString(R.string.llamafile_page)
        )
    )
}

fun getCalendarTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.tuta),
            description = context.getString(R.string.tuta_description),
            icon = R.drawable.tuta,
            homepage = context.getString(R.string.tuta_page)
        ),
        Tool(
            title = context.getString(R.string.proton_calendar),
            description = context.getString(R.string.protoncalendar_description),
            icon = R.drawable.proton_calendar,
            homepage = context.getString(R.string.protoncalendar_page)
        )
    )
}

fun getCryptocurrencyTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.monero),
            description = context.getString(R.string.monero_description),
            icon = R.drawable.monero,
            homepage = context.getString(R.string.monero_page)
        ),
        Tool(
            title = context.getString(R.string.cake_wallet),
            description = context.getString(R.string.cakewallet_description),
            icon = R.drawable.cakewallet,
            homepage = context.getString(R.string.cakewallet_page)
        ),
        Tool(
            title = context.getString(R.string.monerujo),
            description = context.getString(R.string.monerujo_description),
            icon = R.drawable.monerujo,
            homepage = context.getString(R.string.monerujo_page)
        ),
        Tool(
            title = context.getString(R.string.feather_wallet),
            description = context.getString(R.string.feather_description),
            icon = R.drawable.feather_wallet,
            homepage = context.getString(R.string.featherwallet_page)
        )
    )
}

fun getMetadataTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.mat2),
            description = context.getString(R.string.mat2_description),
            icon = R.drawable.mat2,
            homepage = context.getString(R.string.mat2_page)
        ),
        Tool(
            title = context.getString(R.string.exiferaser),
            description = context.getString(R.string.exiferaser_description),
            icon = R.drawable.exiferaser,
            homepage = context.getString(R.string.exiferaser_page)
        ),
        Tool(
            title = context.getString(R.string.exiftool),
            description = context.getString(R.string.exiftool_description),
            icon = R.drawable.exiftool,
            homepage = context.getString(R.string.exiftool_page)
        )
    )
}

fun getDocumentCollaborationTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.cryptpad),
            description = context.getString(R.string.cryptpad_description),
            icon = R.drawable.cryptpad,
            homepage = context.getString(R.string.cryptpad_page)
        )
    )
}

fun getEmailClientsTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.thunderbird),
            description = context.getString(R.string.thunderbird_description),
            icon = R.drawable.thunderbird,
            homepage = context.getString(R.string.thunderbird_page)
        ),
        Tool(
            title = context.getString(R.string.apple_mail),
            description = context.getString(R.string.applemail_description),
            icon = R.drawable.applemail,
            homepage = context.getString(R.string.applemail_page)
        ),
        Tool(
            title = context.getString(R.string.fairemail),
            description = context.getString(R.string.fairemail_description),
            icon = R.drawable.fairemail,
            homepage = context.getString(R.string.fairemail_page)
        ),
        Tool(
            title = context.getString(R.string.evolution),
            description = context.getString(R.string.evolution_description),
            icon = R.drawable.evolution,
            homepage = context.getString(R.string.evolution_page)
        ),
        Tool(
            title = context.getString(R.string.kontact),
            description = context.getString(R.string.kontact_description),
            icon = R.drawable.kontact,
            homepage = context.getString(R.string.kontact_page)
        ),
        Tool(
            title = context.getString(R.string.mailvelope),
            description = context.getString(R.string.mailvelope_description),
            icon = R.drawable.mailvelope,
            homepage = context.getString(R.string.mailvelope_page)
        ),
        Tool(
            title = context.getString(R.string.neomutt),
            description = context.getString(R.string.neomutt_description),
            icon = R.drawable.mutt,
            homepage = context.getString(R.string.neomutt_page)
        )
    )
}

fun getEncryptionTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.cryptomator),
            description = context.getString(R.string.cryptomator_description),
            icon = R.drawable.cryptomator,
            homepage = context.getString(R.string.cryptomator_page)
        ),
        Tool(
            title = context.getString(R.string.veracrypt),
            description = context.getString(R.string.veracrypt_description),
            icon = R.drawable.veracrypt,
            homepage = context.getString(R.string.veracrypt_page)
        ),
        Tool(
            title = context.getString(R.string.bitlocker),
            description = context.getString(R.string.bitlocker_description),
            icon = R.drawable.bitlocker,
            homepage = context.getString(R.string.bitlocker_page)
        ),
        Tool(
            title = context.getString(R.string.filevault),
            description = context.getString(R.string.filevault_description),
            icon = R.drawable.filevault,
            homepage = context.getString(R.string.filevault_page)
        ),
        Tool(
            title = context.getString(R.string.luks),
            description = context.getString(R.string.luks_description),
            icon = R.drawable.luks,
            homepage = context.getString(R.string.luks_page)
        ),
        Tool(
            title = context.getString(R.string.kryptor),
            description = context.getString(R.string.kryptor_description),
            icon = R.drawable.kryptor,
            homepage = context.getString(R.string.kryptor_page)
        ),
        Tool(
            title = context.getString(R.string.tomb),
            description = context.getString(R.string.tomb_description),
            icon = R.drawable.tomb,
            homepage = context.getString(R.string.tomb_page)
        ),
        Tool(
            title = context.getString(R.string.gnupg),
            description = context.getString(R.string.gnupg_description),
            icon = R.drawable.gnupg,
            homepage = context.getString(R.string.gnupg_page)
        ),
        Tool(
            title = context.getString(R.string.gpg4win),
            description = context.getString(R.string.gpg4win_description),
            icon = R.drawable.gpg4win,
            homepage = context.getString(R.string.gpg4win_page)
        ),
        Tool(
            title = context.getString(R.string.gpgsuite),
            description = context.getString(R.string.gpgsuite_description),
            icon = R.drawable.gpgsuite,
            homepage = context.getString(R.string.gpgtools_page)
        ),
        Tool(
            title = context.getString(R.string.openkeychain),
            description = context.getString(R.string.openkeychain_description),
            icon = R.drawable.openkeychain,
            homepage = context.getString(R.string.openkeychain_page)
        )
    )
}

fun getFileSharingTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.send),
            description = context.getString(R.string.send_description),
            icon = R.drawable.send,
            homepage = context.getString(R.string.send_page)
        ),
        Tool(
            title = context.getString(R.string.onionshare),
            description = context.getString(R.string.onionshare_description),
            icon = R.drawable.onionshare,
            homepage = context.getString(R.string.onionshare_page)
        ),
        Tool(
            title = context.getString(R.string.syncthing),
            description = context.getString(R.string.syncthing_description),
            icon = R.drawable.syncthing,
            homepage = context.getString(R.string.syncthing_page)
        )
    )
}

fun getFrontendsTools(context: Context): List<Tool> {
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
        ),
        Tool(
            title = context.getString(R.string.freetube),
            description = context.getString(R.string.freetube_description),
            icon = R.drawable.freetube,
            homepage = context.getString(R.string.freetubeapp_page)
        ),
        Tool(
            title = context.getString(R.string.yattee),
            description = context.getString(R.string.yattee_description),
            icon = R.drawable.yattee,
            homepage = context.getString(R.string.yattee_page)
        ),
        Tool(
            title = context.getString(R.string.libretube),
            description = context.getString(R.string.libretube_description),
            icon = R.drawable.libretube,
            homepage = context.getString(R.string.libretube_page)
        ),
        Tool(
            title = context.getString(R.string.newpipe),
            description = context.getString(R.string.newpipe_description),
            icon = R.drawable.newpipe,
            homepage = context.getString(R.string.newpipe_page)
        )
    )
}

fun getHealthTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.drip),
            description = context.getString(R.string.drip_description),
            icon = R.drawable.drip,
            homepage = context.getString(R.string.drip_page)
        ),
        Tool(
            title = context.getString(R.string.euki),
            description = context.getString(R.string.euki_description),
            icon = R.drawable.euki,
            homepage = context.getString(R.string.eukiapp_page)
        ),
        Tool(
            title = context.getString(R.string.apple_fitness),
            description = context.getString(R.string.apple_fitness_description),
            icon = R.drawable.apple_fitness,
            homepage = context.getString(R.string.apple_fitness_page)
        ),
        Tool(
            title = context.getString(R.string.gadgetbridge),
            description = context.getString(R.string.gadgetbridge_description),
            icon = R.drawable.gadgetbridge,
            homepage = context.getString(R.string.gadgetbridge_page)
        ),
        Tool(
            title = context.getString(R.string.apple_health_records),
            description = context.getString(R.string.applehealth_records_description),
            icon = R.drawable.apple_health,
            homepage = context.getString(R.string.health_page)
        ),
        Tool(
            title = context.getString(R.string.commonhealth),
            description = context.getString(R.string.commonhealth_description),
            icon = R.drawable.commonhealth,
            homepage = context.getString(R.string.commonhealth_page)
        )
    )
}

fun getLanguageTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.languagetool),
            description = context.getString(R.string.languagetool_description),
            icon = R.drawable.languagetool,
            homepage = context.getString(R.string.languagetool_page)
        ),
        Tool(
            title = context.getString(R.string.libretranslate),
            description = context.getString(R.string.libretranslate_description),
            icon = R.drawable.libretranslate,
            homepage = context.getString(R.string.libretranslate_page)
        )
    )
}

fun getMapsTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.organic_maps),
            description = context.getString(R.string.organicmaps_description),
            icon = R.drawable.organic_maps,
            homepage = context.getString(R.string.organicmaps_page)
        ),
        Tool(
            title = context.getString(R.string.osmand),
            description = context.getString(R.string.osmand_description),
            icon = R.drawable.osmand,
            homepage = context.getString(R.string.osmand_page)
        )
    )
}

fun getMultiFactorAuthenticationTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.ente_auth),
            description = context.getString(R.string.enteauth_description),
            icon = R.drawable.ente_auth,
            homepage = context.getString(R.string.auth_page)
        ),
        Tool(
            title = context.getString(R.string.aegis),
            description = context.getString(R.string.aegis_description),
            icon = R.drawable.aegis,
            homepage = context.getString(R.string.aegis_page)
        )
    )
}

fun getNewsAggregatorsTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.akregator),
            description = context.getString(R.string.akregator_description),
            icon = R.drawable.akregator,
            homepage = context.getString(R.string.akregator_page)
        ),
        Tool(
            title = context.getString(R.string.newsflash),
            description = context.getString(R.string.newsflash_description),
            icon = R.drawable.newsflash,
            homepage = context.getString(R.string.newsflash_page)
        ),
        Tool(
            title = context.getString(R.string.feeder),
            description = context.getString(R.string.feeder_description),
            icon = R.drawable.feeder,
            homepage = context.getString(R.string.feeder_page)
        ),
        Tool(
            title = context.getString(R.string.miniflux),
            description = context.getString(R.string.miniflux_description),
            icon = R.drawable.miniflux,
            homepage = context.getString(R.string.miniflux_page)
        ),
        Tool(
            title = context.getString(R.string.netnewswire),
            description = context.getString(R.string.netnewswire_description),
            icon = R.drawable.netnewswire,
            homepage = context.getString(R.string.netnewswire_page)
        ),
        Tool(
            title = context.getString(R.string.newsboat),
            description = context.getString(R.string.newsboat_description),
            icon = R.drawable.newsboat,
            homepage = context.getString(R.string.newsboat_page)
        )
    )
}

fun getNotebooksTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.standard_notes),
            description = context.getString(R.string.standardnotes_description),
            icon = R.drawable.standard_notes,
            homepage = context.getString(R.string.standardnotes_page)
        ),
        Tool(
            title = context.getString(R.string.notesnook),
            description = context.getString(R.string.notesnook_description),
            icon = R.drawable.notesnook,
            homepage = context.getString(R.string.notesnook_page)
        ),
        Tool(
            title = context.getString(R.string.joplin),
            description = context.getString(R.string.joplin_description),
            icon = R.drawable.joplin,
            homepage = context.getString(R.string.joplinapp_page)
        ),
        Tool(
            title = context.getString(R.string.cryptee),
            description = context.getString(R.string.cryptee_description),
            icon = R.drawable.cryptee,
            homepage = context.getString(R.string.cryptee_page)
        ),
        Tool(
            title = context.getString(R.string.orgmode),
            description = context.getString(R.string.orgmode_description),
            icon = R.drawable.org_mode,
            homepage = context.getString(R.string.orgmode_page)
        )
    )
}

fun getOfficeSuitesTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.libreoffice),
            description = context.getString(R.string.libreoffice_description),
            icon = R.drawable.libreoffice,
            homepage = context.getString(R.string.libreoffice_page)
        ),
        Tool(
            title = context.getString(R.string.onlyoffice),
            description = context.getString(R.string.onlyoffice_description),
            icon = R.drawable.onlyoffice,
            homepage = context.getString(R.string.onlyoffice_page)
        )
    )
}

fun getPasswordManagersTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.bitwarden),
            description = context.getString(R.string.bitwarden_description),
            icon = R.drawable.bitwarden,
            homepage = context.getString(R.string.bitwarden_page)
        ),
        Tool(
            title = context.getString(R.string.protonpass),
            description = context.getString(R.string.protonpass_description),
            icon = R.drawable.protonpass,
            homepage = context.getString(R.string.protonpass_page)
        ),
        Tool(
            title = context.getString(R.string._1password),
            description = context.getString(R.string._1password_description),
            icon = R.drawable._password,
            homepage = context.getString(R.string._1password_page)
        ),
        Tool(
            title = context.getString(R.string.psono),
            description = context.getString(R.string.psono_description),
            icon = R.drawable.psono,
            homepage = context.getString(R.string.psono_page)
        ),
        Tool(
            title = context.getString(R.string.keepassxc),
            description = context.getString(R.string.keepassxc_description),
            icon = R.drawable.keepassxc,
            homepage = context.getString(R.string.keepassxc_page)
        ),
        Tool(
            title = context.getString(R.string.keepassdx),
            description = context.getString(R.string.keepassdx_description),
            icon = R.drawable.keepassdx,
            homepage = context.getString(R.string.keepassdx_page)
        ),
        Tool(
            title = context.getString(R.string.keepassium),
            description = context.getString(R.string.keepassium_description),
            icon = R.drawable.keepassium,
            homepage = context.getString(R.string.keepassium_page)
        ),
        Tool(
            title = context.getString(R.string.gopass),
            description = context.getString(R.string.gopass_description),
            icon = R.drawable.gopass,
            homepage = context.getString(R.string.gopass_page)
        )
    )
}

fun getPastebinsTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.privatebin),
            description = context.getString(R.string.privatebin_description),
            icon = R.drawable.privatebin,
            homepage = context.getString(R.string.privatebin_page)
        ),
        Tool(
            title = context.getString(R.string.paaster),
            description = context.getString(R.string.paaster_description),
            icon = R.drawable.paaster,
            homepage = context.getString(R.string.paaster_page)
        )
    )
}

fun getRealTimeCommunicationTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.signal),
            description = context.getString(R.string.signal_description),
            icon = R.drawable.signal,
            homepage = context.getString(R.string.signal_page)
        ),
        Tool(
            title = context.getString(R.string.molly),
            description = context.getString(R.string.molly_description),
            icon = R.drawable.molly,
            homepage = context.getString(R.string.molly_page)
        ),
        Tool(
            title = context.getString(R.string.simplexchat),
            description = context.getString(R.string.simplexchat_description),
            icon = R.drawable.simplex,
            homepage = context.getString(R.string.simplexchat_page)
        ),
        Tool(
            title = context.getString(R.string.briar),
            description = context.getString(R.string.briar_description),
            icon = R.drawable.briar,
            homepage = context.getString(R.string.briarproject_page)
        )
    )
}

fun getSocialNetworksTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.mastodon),
            description = context.getString(R.string.mastodon_description),
            icon = R.drawable.mastodon,
            homepage = context.getString(R.string.mastodon_page)
        ),
        Tool(
            title = context.getString(R.string.element),
            description = context.getString(R.string.element_description),
            icon = R.drawable.element,
            homepage = context.getString(R.string.element_page)
        )
    )
}