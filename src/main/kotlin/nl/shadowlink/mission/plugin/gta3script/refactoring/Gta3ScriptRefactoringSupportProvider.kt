package nl.shadowlink.mission.plugin.gta3script.refactoring

import com.intellij.lang.refactoring.RefactoringSupportProvider
import com.intellij.psi.PsiElement
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptLabel
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptVariable

class Gta3ScriptRefactoringSupportProvider : RefactoringSupportProvider() {

    override fun isMemberInplaceRenameAvailable(element: PsiElement, context: PsiElement?): Boolean {
        return (element is Gta3ScriptVariable ||
                element is Gta3ScriptLabel)
    }
}