package nl.shadowlink.mission.plugin.run

import com.intellij.execution.Executor
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.execution.configurations.RunConfigurationBase
import com.intellij.execution.configurations.RunProfileState
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import nl.shadowlink.mission.plugin.run.ui.MissionRunConfigSettingsEditor

class MissionRunConfiguration(project: Project, factory: ConfigurationFactory?, name: String?) : RunConfigurationBase<MissionRunState>(project, factory, name) {

    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration> {
        return MissionRunConfigSettingsEditor(null)
    }

    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState? {
        return null
    }
}