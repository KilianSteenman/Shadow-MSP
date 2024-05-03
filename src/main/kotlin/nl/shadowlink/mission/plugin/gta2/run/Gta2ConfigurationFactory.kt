package nl.shadowlink.mission.plugin.gta2.run

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.openapi.components.BaseState
import com.intellij.openapi.project.Project
import nl.shadowlink.mission.plugin.gta2.Gta2MissionLanguage

class Gta2ConfigurationFactory : ConfigurationFactory(Gta2ConfigurationType) {

    override fun getId(): String = Gta2MissionLanguage.id

    override fun createTemplateConfiguration(project: Project): RunConfiguration =
        Gta2RunConfiguration(project, this, "GTA 2 Mission Script")

    override fun getOptionsClass(): Class<out BaseState> = Gta2RunConfigurationOptions::class.java
}