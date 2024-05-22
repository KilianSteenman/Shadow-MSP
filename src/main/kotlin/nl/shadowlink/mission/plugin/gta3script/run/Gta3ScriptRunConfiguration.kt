package nl.shadowlink.mission.plugin.gta3script.run

import com.intellij.execution.Executor
import com.intellij.execution.configurations.*
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import nl.shadowlink.mission.plugin.GameType
import java.io.File

internal class Gta3ScriptRunConfiguration(
    project: Project,
    factory: ConfigurationFactory?,
    name: String?
) : RunConfigurationBase<Gta3ScriptRunConfigurationOptions>(project, factory, name) {

    var gameType: GameType
        get() = options.gameType
        set(value) {
            options.gameType = value
        }

    var gamePath: String?
        get() = options.gamePath
        set(value) {
            options.gamePath = value
        }

    var scriptFile: String?
        get() = options.script
        set(value) {
            options.script = value
        }

    override fun getOptions(): Gta3ScriptRunConfigurationOptions {
        return super.getOptions() as Gta3ScriptRunConfigurationOptions
    }

    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration> = Gta3ScriptRunConfigSettingsEditor()

    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState {
        return Gta3ScriptRunState(options, environment)
    }

    override fun checkConfiguration() {
        when {
            gamePath.isNullOrEmpty() -> throwInvalidGamePathException("Empty")
            !File("$gamePath/${gameType.exeName}").exists() -> throwInvalidGamePathException("Invalid")
            else -> super.checkConfiguration()
        }
    }

    private fun throwInvalidGamePathException(reason: String) {
        throw RuntimeConfigurationException("$reason gamepath selected, make sure you select the directory that contains '${gameType.exeName}'")
    }
}
