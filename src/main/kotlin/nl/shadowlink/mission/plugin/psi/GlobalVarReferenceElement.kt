package nl.shadowlink.mission.plugin.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil

class GlobalVarReferenceElement(node: ASTNode) : ASTWrapperPsiElement(node) {

    override fun getName(): String {
        return node.text.substring(1)
    }

    override fun getReference(): PsiReference? {
        var sibling = PsiTreeUtil.getNextSiblingOfType(this, GlobalVarReferenceElement::class.java)
        while (sibling != null && sibling.name != this.name) {
            sibling = PsiTreeUtil.getNextSiblingOfType(sibling, GlobalVarReferenceElement::class.java)
        }

        if (sibling == null) {
            sibling = PsiTreeUtil.getPrevSiblingOfType(this, GlobalVarReferenceElement::class.java)
            while (sibling != null && sibling.name != this.name) {
                sibling = PsiTreeUtil.getPrevSiblingOfType(sibling, GlobalVarReferenceElement::class.java)
            }
        }

        if (sibling != null) {
            return object : PsiReferenceBase<GlobalVarReferenceElement>(this, TextRange(0, this.textLength)) {
                override fun resolve(): PsiElement? {
                    return sibling
                }

                override fun handleElementRename(newName: String): PsiElement {
                    val replacement = PsiElementFactory(this@GlobalVarReferenceElement.project).createLabelReference(newName)
                    return this@GlobalVarReferenceElement.replace(replacement)
                }
            }
        } else {
            return null
        }
    }
}