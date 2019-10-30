package nl.shadowlink.mission.plugin.sb

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.OSProcessHandler
import com.intellij.openapi.vfs.VirtualFile
import nl.shadowlink.mission.plugin.configuration.MissionSettings
import nl.shadowlink.mission.plugin.extensions.logInfo

class SannyBuilderFileOpener {

    fun openFile(file: VirtualFile, missionSettings: MissionSettings) {
        OSProcessHandler(GeneralCommandLine()
                .withExePath("wine")
                .withParameters(missionSettings.sannyPath)
                .withParameters(file.path)
                .also { logInfo(it.commandLineString) }
        )
    }
}