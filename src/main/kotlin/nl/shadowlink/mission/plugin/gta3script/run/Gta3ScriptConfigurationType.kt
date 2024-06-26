package nl.shadowlink.mission.plugin.gta3script.run

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationTypeBase
import nl.shadowlink.mission.plugin.MissionIcons
import nl.shadowlink.mission.plugin.gta3script.Gta3ScriptLanguage

class Gta3ScriptConfigurationType : ConfigurationTypeBase(
    id = ID,
    displayName = Gta3ScriptLanguage.displayName,
    description = null,
    icon = MissionIcons.FILE
) {

    init {
        addFactory(Gta3ScriptConfigurationFactory(this))
    }

    companion object {
        const val ID: String = "Gta3ScriptConfiguration"
    }
}