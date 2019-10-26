package nl.shadowlink.mission.plugin.run

import com.intellij.execution.ExecutionException
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.OSProcessHandler
import com.intellij.execution.process.ProcessAdapter
import com.intellij.execution.process.ProcessEvent
import com.intellij.execution.ui.ConsoleView
import com.intellij.execution.ui.ConsoleViewContentType
import nl.shadowlink.mission.plugin.extensions.println
import nl.shadowlink.mission.plugin.game.Game

internal class MissionCompiler {

    fun compileFile(file: String, game: Game, console: ConsoleView, fileCompiled: (() -> Unit)?) {
        console.println("Compiling $file", ConsoleViewContentType.NORMAL_OUTPUT)
        try {
            val handler = OSProcessHandler(GeneralCommandLine()
                    .withExePath("wine")
                    .withParameters("/Users/kilian/.wine/drive_c/Program Files/Sanny Builder 3/sanny.exe")
                    .withParameters("\\${game.sannyGameTypeParam}")
                    .withParameters("\\nosplash")
                    .withParameters("\\compile")
                    .withParameters(file)
            )
            handler.startNotify()
            handler.addProcessListener(object : ProcessAdapter() {

                override fun processTerminated(event: ProcessEvent) {
                    console.println("Compilation done")
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