package nl.shadowlink.mission.plugin.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.vfs.VirtualFile
import nl.shadowlink.mission.plugin.configuration.MissionSettings
import nl.shadowlink.mission.plugin.sb.SannyBuilderFileOpener

class OpenInSannyBuilderAction : AnAction() {

    override fun actionPerformed(event: AnActionEvent) {
        val file = event.dataContext.getData(PlatformDataKeys.VIRTUAL_FILE) as VirtualFile

        SannyBuilderFileOpener().openFile(file, MissionSettings())
    }

    override fun update(event: AnActionEvent) {
        super.update(event)

        val dataContext = event.dataContext.getData(PlatformDataKeys.VIRTUAL_FILE)
        event.presentation.isEnabledAndVisible = dataContext is VirtualFile && dataContext.extension == "dsc"
    }
}