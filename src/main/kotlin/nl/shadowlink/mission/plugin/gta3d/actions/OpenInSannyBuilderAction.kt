package nl.shadowlink.mission.plugin.gta3d.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.vfs.VirtualFile
import nl.shadowlink.mission.plugin.gta3d.configuration.MissionSettings
import nl.shadowlink.mission.plugin.gta3d.sb.SannyBuilderFileOpener

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