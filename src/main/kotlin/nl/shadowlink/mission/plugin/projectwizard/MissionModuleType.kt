package nl.shadowlink.mission.plugin.projectwizard

import com.intellij.openapi.module.ModuleType
import nl.shadowlink.mission.plugin.MissionIcons
import nl.shadowlink.mission.plugin.MissionLanguage

internal object MissionModuleType : ModuleType<MissionModuleBuilder>("MissionModule") {

    override fun createModuleBuilder() = MissionModuleBuilder()

    override fun getName(): String = MissionLanguage.displayName

    override fun getDescription(): String = "Create a GTA mission script project"

    override fun getNodeIcon(isOpened: Boolean) = MissionIcons.FILE
}