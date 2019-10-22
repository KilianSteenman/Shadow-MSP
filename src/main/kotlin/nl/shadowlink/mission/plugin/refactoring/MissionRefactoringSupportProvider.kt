package nl.shadowlink.mission.plugin.refactoring

import com.intellij.lang.refactoring.RefactoringSupportProvider
import com.intellij.psi.PsiElement
import nl.shadowlink.mission.plugin.psi.LabelDefinitionElement
import nl.shadowlink.mission.plugin.psi.LabelReferenceElement

class MissionRefactoringSupportProvider : RefactoringSupportProvider() {

    override fun isMemberInplaceRenameAvailable(element: PsiElement, context: PsiElement?): Boolean {
        return element is LabelDefinitionElement || element is LabelReferenceElement
    }
}