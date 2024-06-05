package nl.shadowlink.mission.plugin.gta3script.actions

import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import nl.shadowlink.mission.plugin.MissionIcons

class CreateScriptAction : CreateFileFromTemplateAction("GTA Script", "Create new GTA Script", MissionIcons.FILE) {

    override fun buildDialog(
        project: Project,
        psiDirectory: PsiDirectory,
        builder: CreateFileFromTemplateDialog.Builder
    ) {
        builder.apply {
            setTitle("GTA Script")
            addKind("Main script", null, "main-vc")
            addKind("Subscript", null, "subscript")
            addKind("Mission script", null, "mission-script")
            addKind("Custom script", null, "Option C.kt.ft")
        }
    }

    override fun getActionName(psiDirectory: PsiDirectory?, p1: String, p2: String?): String {
        return "Create GTA Script"
    }
}