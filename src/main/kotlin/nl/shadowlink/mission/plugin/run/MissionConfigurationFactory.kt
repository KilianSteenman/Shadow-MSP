package nl.shadowlink.mission.plugin.run

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.openapi.project.Project
import nl.shadowlink.mission.plugin.MissionLanguage

class MissionConfigurationFactory : ConfigurationFactory(MissionConfigurationType) {

    override fun getId(): String = MissionLanguage.id

    override fun createTemplateConfiguration(project: Project): RunConfiguration =
        MissionRunConfiguration(project, this, "GTA Mission Script");
}