package nl.shadowlink.mission.plugin.psi.global

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil
import nl.shadowlink.mission.plugin.psi.PsiElementFactory

class GlobalVarReferenceElement(node: ASTNode) : GlobalVarElement(node) {

    override fun getReference(): PsiReference? {
        val file = PsiTreeUtil.getParentOfType(this, PsiFile::class.java)
        val defs = PsiTreeUtil.collectElementsOfType(file, GlobalVarDefinitionElement::class.java)
        val globalVarDef = defs.firstOrNull { definition -> definition.name == this.name }

        if (globalVarDef != null) {
            return object : PsiReferenceBase<GlobalVarReferenceElement>(this, TextRange(0, this.textLength)) {
                override fun resolve(): PsiElement? {
                    return globalVarDef
                }

                override fun handleElementRename(newName: String): PsiElement {
                    val replacement = PsiElementFactory(this@GlobalVarReferenceElement.project).createGlobalVar(newName)
                    return this@GlobalVarReferenceElement.replace(replacement)
                }
            }
        } else {
            return null
        }
    }
}