package nl.shadowlink.mission.plugin.gta3script.projectwizard

import com.intellij.openapi.module.ModuleType
import nl.shadowlink.mission.plugin.MissionIcons
import nl.shadowlink.mission.plugin.gta3script.Gta3ScriptFileType

internal class GtaScriptModuleType : ModuleType<GtaScriptModuleBuilder>("GtaScriptModule") {

    override fun createModuleBuilder() = GtaScriptModuleBuilder()

    override fun getName(): String = Gta3ScriptFileType.DisplayName

    override fun getDescription(): String = "Create a GTA Script project"

    override fun getNodeIcon(isOpened: Boolean) = MissionIcons.FILE
}