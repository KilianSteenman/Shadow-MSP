package nl.shadowlink.mission.plugin.gta3d.psi.local

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil
import nl.shadowlink.mission.plugin.gta3d.psi.PsiElementFactory
import nl.shadowlink.mission.plugin.gta3d.psi.opcode.OpcodeParameterElement

class LocalVarReferenceElement(node: ASTNode) : OpcodeParameterElement(node) {

    override fun getReference(): PsiReference? {
        val file = PsiTreeUtil.getParentOfType(this, PsiFile::class.java)
        val defs = PsiTreeUtil.collectElementsOfType(file, LocalVarDefinitionElement::class.java)
        val localVarDef = defs.firstOrNull { definition -> definition.name == this.name }

        if (localVarDef != null) {
            return object : PsiReferenceBase<LocalVarReferenceElement>(this, TextRange(0, this.textLength)) {
                override fun resolve(): PsiElement? {
                    return localVarDef
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