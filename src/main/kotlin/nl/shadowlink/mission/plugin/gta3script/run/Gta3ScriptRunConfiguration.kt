package nl.shadowlink.mission.plugin.gta3script.run

import com.intellij.execution.Executor
import com.intellij.execution.configurations.*
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import java.io.File

internal class Gta3ScriptRunConfiguration(
    project: Project,
    factory: ConfigurationFactory?,
    name: String?
) : RunConfigurationBase<Gta3ScriptRunConfigurationOptions>(project, factory, name) {

    var gamePath: String
        get() = options.gamePath
        set(value) {
            options.gamePath = value
        }

    override fun getOptions(): Gta3ScriptRunConfigurationOptions {
        return super.getOptions() as Gta3ScriptRunConfigurationOptions
    }

    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration> = Gta3ScriptRunConfigSettingsEditor()

    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState {
        return Gta3ScriptRunState(options, environment)
    }

    override fun checkConfiguration() {
        // TODO: Implement EXE checks
        when {
            gamePath.isEmpty() ->
                throw RuntimeConfigurationException("GTA directory not set, make sure you select the directory that contains gta2.exe.")

            !File("$gamePath/gta3.exe").exists() ->
                throw RuntimeConfigurationException("'$gamePath' is not a valid GTA directory. Select the directory that contains gta2.exe.")

            else -> super.checkConfiguration()
        }
    }
}