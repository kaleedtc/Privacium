
package com.kaleedtc.privacium.data.provider

import android.content.Context
import com.kaleedtc.privacium.R
import com.kaleedtc.privacium.data.Tool

fun getDesktopTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.fedora),
            description = context.getString(R.string.fedora_description),
            icon = R.drawable.fedora,
            homepage = context.getString(R.string.fedoraproject_page)
        ),
        Tool(
            title = context.getString(R.string.opensuse_tumbleweed),
            description = context.getString(R.string.opensuse_tumbleweed_description),
            icon = R.drawable.opensuse_tumbleweed,
            homepage = context.getString(R.string.tumbleweed_page)
        ),
        Tool(
            title = context.getString(R.string.arch_linux),
            description = context.getString(R.string.arch_description),
            icon = R.drawable.archlinux,
            homepage = context.getString(R.string.archlinux_page)
        ),
        Tool(
            title = context.getString(R.string.fedora_atomic),
            description = context.getString(R.string.atomic_description),
            icon = R.drawable.fedora,
            homepage = context.getString(R.string.atomic_page)
        ),
        Tool(
            title = context.getString(R.string.nixos),
            description = context.getString(R.string.nixos_description),
            icon = R.drawable.nixos,
            homepage = context.getString(R.string.nixos_page)
        ),
        Tool(
            title = context.getString(R.string.whonix),
            description = context.getString(R.string.whonix_description),
            icon = R.drawable.whonix,
            homepage = context.getString(R.string.whonix_page)
        ),
        Tool(
            title = context.getString(R.string.tails),
            description = context.getString(R.string.tails_description),
            icon = R.drawable.tails,
            homepage = context.getString(R.string.tails_page)
        ),
        Tool(
            title = context.getString(R.string.qubes_os),
            description = context.getString(R.string.qubesos_description),
            icon = R.drawable.qubes_os,
            homepage = context.getString(R.string.qubes_page)
        ),
        Tool(
            title = context.getString(R.string.secureblue),
            description = context.getString(R.string.secureblue_description),
            icon = R.drawable.secureblue,
            homepage = context.getString(R.string.secureblue_page)
        ),
        Tool(
            title = context.getString(R.string.kicksecure),
            description = context.getString(R.string.kicksecure_description),
            icon = R.drawable.kicksecure,
            homepage = context.getString(R.string.kicksecure_page)
        )
    )
}

fun getAndroidTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.grapheneos),
            description = context.getString(R.string.grapheneos_description),
            icon = R.drawable.grapheneos,
            homepage = context.getString(R.string.grapheneos_page)
        ),
        Tool(
            title = context.getString(R.string.shelter),
            description = context.getString(R.string.shelter_description),
            icon = R.drawable.shelter,
            homepage = context.getString(R.string.shelter_page)
        ),
        Tool(
            title = context.getString(R.string.secure_camera),
            description = context.getString(R.string.secure_camera_description),
            icon = R.drawable.secure_camera,
            homepage = context.getString(R.string.camera_page)
        ),
        Tool(
            title = context.getString(R.string.secure_pdf_viewer),
            description = context.getString(R.string.pdfviewer_description),
            icon = R.drawable.secure_pdf_viewer,
            homepage = context.getString(R.string.pdfviewer_page)
        ),
        Tool(
            title = context.getString(R.string.obtainium),
            description = context.getString(R.string.obtainium_description),
            icon = R.drawable.obtainium,
            homepage = context.getString(R.string.obtainium_page)
        ),
        Tool(
            title = context.getString(R.string.aurora_store),
            description = context.getString(R.string.aurora_store_description),
            icon = R.drawable.aurora_store,
            homepage = context.getString(R.string.auroraoss_page)
        ),
        Tool(
            title = context.getString(R.string.f_droid),
            description = context.getString(R.string.f_droid_description),
            icon = R.drawable.f_droid,
            homepage = context.getString(R.string.f_droid_page)
        )
    )
}

fun getRouterFirmwareTools(context: Context): List<Tool> {
    return listOf(
        Tool(
            title = context.getString(R.string.openwrt),
            description = context.getString(R.string.openwrt_description),
            icon = R.drawable.openwrt,
            homepage = context.getString(R.string.openwrt_page)
        ),
        Tool(
            title = context.getString(R.string.opnsense),
            description = context.getString(R.string.opnsense_description),
            icon = R.drawable.opnsense,
            homepage = context.getString(R.string.opnsense_page)
        )
    )
}
