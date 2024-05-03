package nl.shadowlink.mission.plugin.gta3d.psi.defines

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import nl.shadowlink.mission.plugin.gta3d.psi.PsiElementFactory

class ObjectNameElement(node: ASTNode) : ASTWrapperPsiElement(node), PsiNamedElement {

    val objectName get() = text

    override fun setName(name: String): PsiElement {
        val replacement = PsiElementFactory(this.project).createObjectName(name)
        return this.replace(replacement)
    }
}