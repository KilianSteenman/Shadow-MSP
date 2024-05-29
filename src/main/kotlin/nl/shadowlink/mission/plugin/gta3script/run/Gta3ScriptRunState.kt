package nl.shadowlink.mission.plugin.gta3script.run

import com.intellij.execution.configurations.CommandLineState
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.ProcessHandlerFactory
import com.intellij.execution.process.ProcessTerminatedListener
import com.intellij.execution.runners.ExecutionEnvironment
import nl.shadowlink.mission.plugin.settings.ShadowMspSettings

class Gta3ScriptRunState(
    private val options: Gta3ScriptRunConfigurationOptions,
    environment: ExecutionEnvironment
) : CommandLineState(environment) {
    override fun startProcess(): ProcessHandler {

        val settings = ShadowMspSettings()
        settings.verifyGtaScriptCompiler()

        val gameType = requireNotNull(options.gameType) { "GameType not set" }
        val script = requireNotNull(options.script) { "Script not set" }

        val compileCommandLine = GeneralCommandLine()
            .withExePath(settings.gta3scPath)
            // TODO: Change work directory?
            .withWorkDirectory(environment.project.basePath)
            .withParameters("${requireNotNull(environment.project.basePath)}/$script")
            .withParameters("--config=${gameType.gta3scConfig}")
            .apply {
                // Optionally set the data directory
                val dataDir = options.dataDir
                if (dataDir?.isNotEmpty() == true) {
                    withParameters("--datadir=$dataDir")
                }
            }
        return ProcessHandlerFactory.getInstance()
            .createColoredProcessHandler(compileCommandLine).apply {
                ProcessTerminatedListener.attach(this)
            }
    }
}