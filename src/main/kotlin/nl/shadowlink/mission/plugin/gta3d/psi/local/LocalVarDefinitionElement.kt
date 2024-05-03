package nl.shadowlink.mission.plugin.gta3d.psi.local

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import nl.shadowlink.mission.plugin.gta3d.psi.PsiElementFactory

class LocalVarDefinitionElement(node: ASTNode) : LocalVarElement(node), PsiNamedElement {

    override fun setName(name: String): PsiElement {
        val replacement = PsiElementFactory(this.project).createLocalVar(name)
        return this.replace(replacement)
    }
}