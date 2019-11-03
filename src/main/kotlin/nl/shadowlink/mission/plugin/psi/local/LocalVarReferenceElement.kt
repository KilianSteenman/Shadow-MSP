package nl.shadowlink.mission.plugin.psi.local

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil
import nl.shadowlink.mission.plugin.psi.PsiElementFactory

class LocalVarReferenceElement(node: ASTNode) : LocalVarElement(node) {

    override fun getReference(): PsiReference? {
        val file = PsiTreeUtil.getParentOfType(this, PsiFile::class.java)
        val defs = PsiTreeUtil.collectElementsOfType(file, LocalVarDefinitionElement::class.java)
        val labelDef = defs.firstOrNull { definition -> definition.name == this.name }

        if (labelDef != null) {
            return object : PsiReferenceBase<LocalVarReferenceElement>(this, TextRange(0, this.textLength)) {
                override fun resolve(): PsiElement? {
                    return labelDef
                }

                override fun handleElementRename(newName: String): PsiElement {
                    val replacement = PsiElementFactory(this@LocalVarReferenceElement.project).createLabelReference(newName)
                    return this@LocalVarReferenceElement.replace(replacement)
                }
            }
        } else {
            return null
        }
    }
}