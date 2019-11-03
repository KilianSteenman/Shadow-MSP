package nl.shadowlink.mission.plugin.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil
import nl.shadowlink.mission.plugin.extensions.logWarn

class LabelReferenceElement(node: ASTNode) : ASTWrapperPsiElement(node) {

    override fun getName(): String {
        return node.text.substring(1)
    }

    override fun getReference(): PsiReference? {
        val file = PsiTreeUtil.getParentOfType(this, PsiFile::class.java)
        val labelDefinitions = PsiTreeUtil.collectElementsOfType(file, LabelDefinitionElement::class.java)
        val labelDef = labelDefinitions.firstOrNull { definition -> definition.name == this.name }

        if (labelDef != null) {
            return object : PsiReferenceBase<LabelReferenceElement>(this, TextRange(0, this.textLength)) {
                override fun resolve(): PsiElement? {
                    return labelDef
                }

                override fun handleElementRename(newName: String): PsiElement {
                    val replacement = PsiElementFactory(this@LabelReferenceElement.project).createLabelReference(newName)
                    return this@LabelReferenceElement.replace(replacement)
                }
            }
        } else {
            return null
        }
    }
}