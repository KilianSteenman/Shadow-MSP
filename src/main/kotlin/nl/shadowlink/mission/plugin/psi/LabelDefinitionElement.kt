package nl.shadowlink.mission.plugin.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement

class LabelDefinitionElement(node: ASTNode): ASTWrapperPsiElement(node), PsiNamedElement {

    override fun getName(): String? {
        return node.text.substring(1)
    }

    override fun setName(name: String): PsiElement {
        val replacement = PsiElementFactory(this.project).createLabelDefinition(name)
        return this.replace(replacement)
    }
}