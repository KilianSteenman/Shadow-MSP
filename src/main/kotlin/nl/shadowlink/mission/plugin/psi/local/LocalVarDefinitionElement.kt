package nl.shadowlink.mission.plugin.psi.local

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import nl.shadowlink.mission.plugin.psi.PsiElementFactory

class LocalVarDefinitionElement(node: ASTNode) : LocalVarElement(node), PsiNamedElement {

    override fun setName(name: String): PsiElement {
        val replacement = PsiElementFactory(this.project).createLocalVar(name)
        return this.replace(replacement)
    }
}