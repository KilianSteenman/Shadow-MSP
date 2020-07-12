package nl.shadowlink.mission.plugin.psi.params

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil
import nl.shadowlink.mission.plugin.annotator.Annotatable
import nl.shadowlink.mission.plugin.game.models.ModelNameProviderFactory
import nl.shadowlink.mission.plugin.psi.PsiElementFactory
import nl.shadowlink.mission.plugin.psi.defines.ObjectNameElement
import nl.shadowlink.mission.plugin.psi.opcode.OpcodeParameterElement

class ModelElement(node: ASTNode) : OpcodeParameterElement(node), Annotatable {

    private val modelName get() = node.text.substring(1)

    override fun annotate(holder: AnnotationHolder) {
        if (reference == null && !ModelNameProviderFactory.getProvider().isValidModel(modelName)) {
            holder.createErrorAnnotation(this, "$modelName is not a valid model")
        } else {
            super.annotate(holder)
        }
    }

    override fun getReference(): PsiReference? {
        val file = PsiTreeUtil.getParentOfType(this, PsiFile::class.java)
        val objectDef = PsiTreeUtil.collectElementsOfType(file, ObjectNameElement::class.java)
                .firstOrNull { objectElement -> objectElement.objectName == this.modelName }

        if (objectDef != null) {
            return object : PsiReferenceBase<ModelElement>(this, TextRange(0, this.textLength)) {
                override fun resolve(): PsiElement? {
                    return objectDef
                }

                override fun handleElementRename(newName: String): PsiElement {
                    val replacement = PsiElementFactory(this@ModelElement.project).createObjectName(newName)
                    return this@ModelElement.replace(replacement)
                }
            }
        } else {
            return null
        }
    }
}