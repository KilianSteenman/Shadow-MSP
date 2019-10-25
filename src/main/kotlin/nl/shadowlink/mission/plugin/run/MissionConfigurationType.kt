package nl.shadowlink.mission.plugin.run

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationTypeBase
import nl.shadowlink.mission.plugin.MissionIcons
import nl.shadowlink.mission.plugin.MissionLanguage

object MissionConfigurationType : ConfigurationTypeBase(MissionLanguage.id, MissionLanguage.displayName, null, MissionIcons.FILE) {

    override fun getConfigurationFactories(): Array<ConfigurationFactory> =
            arrayOf(MissionConfigurationFactory())
}