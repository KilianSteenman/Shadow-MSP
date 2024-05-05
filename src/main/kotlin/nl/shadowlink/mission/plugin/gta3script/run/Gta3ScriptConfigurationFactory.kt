package nl.shadowlink.mission.plugin.gta3script.run

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.openapi.components.BaseState
import com.intellij.openapi.project.Project
import nl.shadowlink.mission.plugin.gta3script.Gta3ScriptLanguage

class Gta3ScriptConfigurationFactory(type: Gta3ScriptConfigurationType) : ConfigurationFactory(type) {

    override fun getId(): String = Gta3ScriptLanguage.id

    override fun createTemplateConfiguration(project: Project): RunConfiguration =
        Gta3ScriptRunConfiguration(project, this, "GTA Mission Script")

    override fun getOptionsClass(): Class<out BaseState> = Gta3ScriptRunConfigurationOptions::class.java
}