package nl.shadowlink.mission.plugin.gta3d.run

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.ui.ConsoleView
import com.intellij.execution.ui.ConsoleViewContentType
import nl.shadowlink.mission.plugin.utils.println

class GameLauncher {

    fun launchGame(console: ConsoleView, gamePath: String) {
        console.println("Launching game...")

        GeneralCommandLine()
                .withExePath("$gamePath/gta-vc.exe")
                .also { console.println(it.commandLineString, ConsoleViewContentType.LOG_DEBUG_OUTPUT) }
                .createProcess()
    }
}