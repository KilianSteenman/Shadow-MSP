package nl.shadowlink.mission.plugin.psi.global

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import nl.shadowlink.mission.plugin.psi.PsiElementFactory

class GlobalVarDefinitionElement(node: ASTNode) : GlobalVarElement(node), PsiNamedElement {

    override fun setName(name: String): PsiElement {
        val replacement = PsiElementFactory(this.project).createGlobalVar(name)
        return this.replace(replacement)
    }
}