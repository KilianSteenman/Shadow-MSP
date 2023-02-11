package nl.shadowlink.mission.plugin.gta2.run

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationTypeBase
import nl.shadowlink.mission.plugin.MissionIcons
import nl.shadowlink.mission.plugin.gta2.Gta2MissionLanguage

object Gta2ConfigurationType : ConfigurationTypeBase(
    Gta2MissionLanguage.id,
    Gta2MissionLanguage.displayName,
    null,
    MissionIcons.FILE
) {

    override fun getConfigurationFactories(): Array<ConfigurationFactory> =
        arrayOf(Gta2ConfigurationFactory())
}