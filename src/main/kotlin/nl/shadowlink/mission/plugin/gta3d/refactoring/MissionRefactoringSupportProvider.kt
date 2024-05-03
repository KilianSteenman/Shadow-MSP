package nl.shadowlink.mission.plugin.gta3d.refactoring

import com.intellij.lang.refactoring.RefactoringSupportProvider
import com.intellij.psi.PsiElement
import nl.shadowlink.mission.plugin.gta3d.psi.label.LabelDefinitionElement
import nl.shadowlink.mission.plugin.gta3d.psi.label.LabelReferenceElement

class MissionRefactoringSupportProvider : RefactoringSupportProvider() {

    override fun isMemberInplaceRenameAvailable(element: PsiElement, context: PsiElement?): Boolean {
        return element is LabelDefinitionElement || element is LabelReferenceElement
    }
}