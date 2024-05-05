package nl.shadowlink.mission.plugin.gta3script.run

import com.intellij.execution.configurations.CommandLineState
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.ProcessHandlerFactory
import com.intellij.execution.process.ProcessTerminatedListener
import com.intellij.execution.runners.ExecutionEnvironment
import nl.shadowlink.mission.plugin.settings.ShadowMspSettings
import java.io.File

class Gta3ScriptRunState(environment: ExecutionEnvironment) : CommandLineState(environment) {
    override fun startProcess(): ProcessHandler {

        val settings = ShadowMspSettings()
        settings.verifyGtaScript()

        // TODO: Clean this all up
        val compileCommandLine = GeneralCommandLine()
            .withExePath(settings.gta3scPath)
            // TODO: Change work directory
            .withWorkDirectory(File(settings.gta3scPath).parent)
//            .withParameters(levelScript.path.replace("/", "\\"))

        return ProcessHandlerFactory.getInstance()
            .createColoredProcessHandler(compileCommandLine).apply {
                ProcessTerminatedListener.attach(this)
            }
    }
}