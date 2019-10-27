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
import nl.shadowlink.mission.plugin.extensions.println
import nl.shadowlink.mission.plugin.game.Game
import java.io.File

internal class MissionCompiler {

    fun compileFile(file: VirtualFile, projectPath: String, gamePath: String, game: Game, console: ConsoleView, fileCompiled: (() -> Unit)?) {
        val filePath = "Z:$projectPath\\${file.name}"
        console.println("Compiling $file", ConsoleViewContentType.NORMAL_OUTPUT)
        try {
            val handler = OSProcessHandler(GeneralCommandLine()
                    .withExePath("wine")
                    .withParameters(MissionSettings().sannyPath)
                    .withParameters("\\${game.sannyGameTypeParam}")
                    .withParameters("\\nosplash")
                    .withParameters("\\compile")
                    .withParameters(filePath)
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

                        if(file.name == "stripped.dsc") {
                            val compiledFile = File("${projectPath.replace("\\", "/")}/stripped.scm")
                            val targetFile = File("${gamePath.replace("\\", "/").replace("/gta-vc.exe", "")}/data/main.scm")
                            compiledFile.copyTo(targetFile, overwrite = true)
                            console.println("Copied to game dir")
                        }
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