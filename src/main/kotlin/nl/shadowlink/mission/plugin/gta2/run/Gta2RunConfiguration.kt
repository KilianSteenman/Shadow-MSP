package nl.shadowlink.mission.plugin.gta2.run

import com.intellij.execution.Executor
import com.intellij.execution.configurations.*
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.ProcessHandlerFactory
import com.intellij.execution.process.ProcessTerminatedListener
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.search.PsiSearchHelper
import nl.shadowlink.mission.plugin.gta2.configuration.Gta2Settings
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

                // Launch GTA-2
//                val commandLine = GeneralCommandLine()
//                    .withExePath("${options.gamePath}\\gta2.exe")
//                    .withWorkDirectory(options.gamePath)

                val levelScript = findLevelScript(environment) ?: throw IllegalStateException("Level script not found")

                // TODO: Clean this all up
                val commandLine = GeneralCommandLine()
                    .withExePath(Gta2Settings().compilerPath)
                    .withWorkDirectory(File(Gta2Settings().compilerPath).parent)
                    .withParameters(levelScript.path.replace("/", "\\"))

                return ProcessHandlerFactory.getInstance()
                    .createColoredProcessHandler(commandLine).apply {
                        ProcessTerminatedListener.attach(this)
                    }
            }
        }
    }

    private fun findLevelScript(environment: ExecutionEnvironment): VirtualFile? {
        // TODO: Support multiple / clean this up?
        return PsiSearchHelper.getInstance(environment.project).findFilesWithPlainTextWords("LEVELSTART")
            .firstOrNull()
            ?.virtualFile
//        val scriptFiles = FileTypeIndex.getFiles(Gta2MissionFileType, GlobalSearchScope.allScope(environment.project))
//        return scriptFiles.firstOrNull()
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