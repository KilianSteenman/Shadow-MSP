package nl.shadowlink.mission.plugin.gta3d.run

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationTypeBase
import nl.shadowlink.mission.plugin.MissionIcons
import nl.shadowlink.mission.plugin.gta3d.MissionLanguage

object MissionConfigurationType : ConfigurationTypeBase(MissionLanguage.id, MissionLanguage.displayName, null, MissionIcons.FILE) {

    override fun getConfigurationFactories(): Array<ConfigurationFactory> =
            arrayOf(MissionConfigurationFactory())
}