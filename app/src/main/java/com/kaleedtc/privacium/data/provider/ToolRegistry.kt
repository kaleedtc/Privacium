package com.kaleedtc.privacium.data.provider

import android.content.Context
import com.kaleedtc.privacium.R
import com.kaleedtc.privacium.data.Tool

typealias ToolProvider = (Context) -> List<Tool>

object ToolRegistry {
    private val toolProviders = mutableMapOf<String, ToolProvider>()

    private fun register(subCategoryName: String, provider: ToolProvider) {
        toolProviders[subCategoryName] = provider
    }

    fun getTools(context: Context, subCategoryName: String): List<Tool> {
        return toolProviders[subCategoryName]?.invoke(context) ?: emptyList()
    }

    fun getAllTools(context: Context): List<Tool> {
        return toolProviders.values.flatMap { it.invoke(context) }.distinct()
    }

    fun initialize(context: Context) {
        register(context.getString(R.string.desktop_browsers)) { getDesktopBrowsersTools(it) }
        register(context.getString(R.string.mobile_browsers)) { getMobileBrowsersTools(it) }
        register(context.getString(R.string.browser_extensions)) { getBrowserExtensionsTools(it) }
        register(context.getString(R.string.torbrowser)) { getTorBrowserTools(it) }
        register(context.getString(R.string.desktop)) { getDesktopTools(it) }
        register(context.getString(R.string.android)) { getAndroidTools(it) }
        register(context.getString(R.string.router_firmware)) { getRouterFirmwareTools(it) }
        register(context.getString(R.string.ai_chat)) { getAiChatTools(it) }
        register(context.getString(R.string.password_managers)) { getPasswordManagersTools(it) }
        register(context.getString(R.string.multifactor_authentication)) { getMultiFactorAuthenticationTools(it) }
        register(context.getString(R.string.email_clients)) { getEmailClientsTools(it) }
        register(context.getString(R.string.calendar)) { getCalendarTools(it) }
        register(context.getString(R.string.office_suites)) { getOfficeSuitesTools(it) }
        register(context.getString(R.string.notebooks)) { getNotebooksTools(it) }
        register(context.getString(R.string.cryptocurrency)) { getCryptocurrencyTools(it) }
        register(context.getString(R.string.file_sharing)) { getFileSharingTools(it) }
        register(context.getString(R.string.metadata)) { getMetadataTools(it) }
        register(context.getString(R.string.document_collaboration)) { getDocumentCollaborationTools(it) }
        register(context.getString(R.string.encryption)) { getEncryptionTools(it) }
        register(context.getString(R.string.frontends)) { getFrontendsTools(it) }
        register(context.getString(R.string.health)) { getHealthTools(it) }
        register(context.getString(R.string.language_tools)) { getLanguageTools(it) }
        register(context.getString(R.string.maps)) { getMapsTools(it) }
        register(context.getString(R.string.news_aggregators)) { getNewsAggregatorsTools(it) }
        register(context.getString(R.string.pastebins)) { getPastebinsTools(it) }
        register(context.getString(R.string.real_time_communication)) { getRealTimeCommunicationTools(it) }
        register(context.getString(R.string.social_networks)) { getSocialNetworksTools(it) }
        register(context.getString(R.string.cloud_storage)) { getCloudStorageTools(it) }
        register(context.getString(R.string.data_removal_services)) { getDataRemovalServicesTools(it) }
        register(context.getString(R.string.dns_resolvers)) { getDnsResolversTools(it) }
        register(context.getString(R.string.email_aliasing)) { getEmailAliasingTools(it) }
        register(context.getString(R.string.email_services)) { getEmailServicesTools(it) }
        register(context.getString(R.string.financial_services)) { getFinancialServicesTools(it) }
        register(context.getString(R.string.photo_management)) { getPhotoManagementTools(it) }
        register(context.getString(R.string.search_engines)) { getSearchEnginesTools(it) }
        register(context.getString(R.string.vpn_services)) { getVpnServicesTools(it) }
        register(context.getString(R.string.mobile_phones)) { getMobilePhonesTools(it) }
        register(context.getString(R.string.security_keys)) { getSecurityKeysTools(it) }
        register(context.getString(R.string.alternative_networks)) { getAdvancedTools(it) }
        register(context.getString(R.string.device_integrity)) { getDeviceIntegrityTools(it) }
        register(context.getString(R.string.email_servers)) { getEmailServersTools(it) }
        register(context.getString(R.string.socialnetworks)) { getSocialNetworksTools(it) }
        register(context.getString(R.string.frontend)) { getFrontendTools(it) }
        register(context.getString(R.string.dns_filtering)) { getDnsFilteringTools(it) }
        register(context.getString(R.string.password_management)) { getPasswordManagementTools(it) }
        register(context.getString(R.string.file_management)) { getFileManagementTools(it) }
    }
}