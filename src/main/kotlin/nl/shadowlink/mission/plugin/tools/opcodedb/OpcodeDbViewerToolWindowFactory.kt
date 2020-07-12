package nl.shadowlink.mission.plugin.tools.opcodedb

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.Content
import com.intellij.ui.content.ContentFactory
import javax.swing.JComponent

class OpcodeDbViewerToolWindowFactory : ToolWindowFactory {

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val viewer = OpcodeDbViewer()
        toolWindow.contentManager.addContent(viewer.createContent().toContent())
    }

    private fun JComponent.toContent(displayName: String = "", isLockable: Boolean = false): Content {
        val contentFactory = ContentFactory.SERVICE.getInstance()
        return contentFactory.createContent(this, displayName, isLockable)
    }
}