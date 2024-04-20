package nl.shadowlink.mission.plugin.gta3script.run

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationTypeBase
import nl.shadowlink.mission.plugin.MissionIcons
import nl.shadowlink.mission.plugin.gta3script.Gta3ScriptLanguage

object Gta3ScriptConfigurationType : ConfigurationTypeBase(
    Gta3ScriptLanguage.id,
    Gta3ScriptLanguage.displayName,
    null,
    MissionIcons.FILE
) {

    override fun getConfigurationFactories(): Array<ConfigurationFactory> =
        arrayOf(Gta3ScriptConfigurationFactory())
}