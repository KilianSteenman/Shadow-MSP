package nl.shadowlink.mission.plugin.sb

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.OSProcessHandler
import com.intellij.openapi.vfs.VirtualFile
import nl.shadowlink.mission.plugin.configuration.MissionSettings
import nl.shadowlink.mission.plugin.extensions.logError
import nl.shadowlink.mission.plugin.extensions.logInfo
import java.io.File

internal class SannyBuilderFileOpener {

    fun openFile(file: VirtualFile, missionSettings: MissionSettings) {
        val sannyExecutablePath = "${missionSettings.sannyPath}/sanny.exe"
        if (!File(sannyExecutablePath).exists()) {
            logError("Unable to locate sanny.exe, make sure your Sanny Builder path is setup correctly in Mission Script settings")
            return
        }

        OSProcessHandler(GeneralCommandLine()
                .withExePath(sannyExecutablePath)
                .withParameters(file.path)
                .also { logInfo(it.commandLineString) }
        )
    }
}