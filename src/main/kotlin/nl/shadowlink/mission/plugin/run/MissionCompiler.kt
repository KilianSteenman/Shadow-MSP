package nl.shadowlink.mission.plugin.run

import com.intellij.execution.ExecutionException
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.OSProcessHandler
import com.intellij.execution.process.ProcessAdapter
import com.intellij.execution.process.ProcessEvent
import com.intellij.execution.ui.ConsoleView
import com.intellij.execution.ui.ConsoleViewContentType
import com.intellij.openapi.vfs.VirtualFile
import nl.shadowlink.mission.plugin.configuration.MissionSettings
import nl.shadowlink.mission.plugin.extensions.moveTo
import nl.shadowlink.mission.plugin.extensions.println
import nl.shadowlink.mission.plugin.game.Game
import java.io.File

internal class MissionCompiler {

    fun compileFile(missionSettings: MissionSettings, runConfig: MissionRunConfiguration, file: VirtualFile, projectPath: String, console: ConsoleView, fileCompiled: (() -> Unit)?) {
        val filePath = "Z:$projectPath\\${file.name}"
        console.println("Compiling $file", ConsoleViewContentType.NORMAL_OUTPUT)
        try {
            val handler = OSProcessHandler(GeneralCommandLine()
                    .withExePath("wine")
                    .withParameters(missionSettings.sannyPath)
                    .withParameters("\\${runConfig.game.sannyGameTypeParam}")
                    .withParameters("\\nosplash")
                    .withParameters("\\compile")
                    .withParameters(filePath)
                    .also { console.println(it.commandLineString, ConsoleViewContentType.LOG_DEBUG_OUTPUT) }
            )
            handler.startNotify()
            handler.addProcessListener(object : ProcessAdapter() {

                override fun processTerminated(event: ProcessEvent) {
                    console.println("Checking ${projectPath.replace("\\", "/")}/compile.log")
                    val sannyLogFile = File("${projectPath.replace("\\", "/")}/compile.log")
                    if(sannyLogFile.exists()) {
                        console.println("Compilation failed", ConsoleViewContentType.ERROR_OUTPUT)
                        console.println(sannyLogFile.readText(), ConsoleViewContentType.ERROR_OUTPUT)
                        sannyLogFile.delete()
                    } else {
                        console.println("Compilation done")
                        val scmName = file.name.replace(".dsc", ".scm")
                        val compiledFile = File("${projectPath.replace("\\", "/")}/$scmName")
                        val targetFile = File("${projectPath.replace("\\", "/")}/output/$scmName")
                        compiledFile.moveTo(targetFile, overwrite = true)
                    }
                    fileCompiled?.invoke()
                }

                override fun startNotified(event: ProcessEvent) {
                    console.println("Compilation starting")
                }
            })
            console.attachToProcess(handler)
        } catch (ex: ExecutionException) {
            ex.printStackTrace()
            return
        }
    }
}