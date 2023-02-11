package nl.shadowlink.mission.plugin.gta2.run

import com.intellij.execution.Executor
import com.intellij.execution.configurations.*
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.ProcessHandlerFactory
import com.intellij.execution.process.ProcessTerminatedListener
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import java.io.File


internal class Gta2RunConfiguration(
    project: Project,
    factory: ConfigurationFactory?,
    name: String?
) : RunConfigurationBase<Gta2RunConfigurationOptions>(project, factory, name) {

    var gamePath: String
        get() = options.gamePath
        set(value) {
            options.gamePath = value
        }

    override fun getOptions(): Gta2RunConfigurationOptions {
        return super.getOptions() as Gta2RunConfigurationOptions
    }

    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration> = Gta2RunConfigSettingsEditor()

    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState {
        return object : CommandLineState(environment) {
            override fun startProcess(): ProcessHandler {
                val commandLine = GeneralCommandLine("${options.gamePath}/gta2.exe")
                val processHandler = ProcessHandlerFactory.getInstance().createColoredProcessHandler(commandLine)
                ProcessTerminatedListener.attach(processHandler)
                return processHandler
            }
        }
    }

    override fun checkConfiguration() {
        when {
            gamePath.isEmpty() ->
                throw RuntimeConfigurationException("GTA-2 directory not set, make sure you select the directory that contains gta2.exe.")

            !File("$gamePath/gta2.exe").exists() ->
                throw RuntimeConfigurationException("'$gamePath' is not a valid GTA-2 directory. Select the directory that contains gta2.exe.")

            else -> super.checkConfiguration()
        }
    }

//    companion object {
//        private const val SETTING_PATH = "setting_path"
//        private const val DEFAULT_PATH = ""
//    }
}