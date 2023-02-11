package nl.shadowlink.mission.plugin.gta3d.psi.label

import com.intellij.lang.ASTNode
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil
import nl.shadowlink.mission.plugin.gta3d.annotator.Annotatable
import nl.shadowlink.mission.plugin.gta3d.psi.PsiElementFactory
import nl.shadowlink.mission.plugin.gta3d.psi.opcode.OpcodeParameterElement
import nl.shadowlink.mission.plugin.gta3d.quickfixes.CreateLabelQuickFix

class LabelReferenceElement(node: ASTNode) : OpcodeParameterElement(node), Annotatable {

    override fun getName(): String {
        return node.text.substring(1)
    }

    override fun annotate(holder: AnnotationHolder) {
        val labelDefinition = findLabelDefinition()
        if (labelDefinition == null) {
            holder.createErrorAnnotation(this, "Unable to find Label $name")
                    .registerFix(CreateLabelQuickFix(this))
        }
    }

    override fun getReference(): PsiReference? {
        val labelDef = findLabelDefinition()

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

    private fun findLabelDefinition(): LabelDefinitionElement? {
        val file = PsiTreeUtil.getParentOfType(this, PsiFile::class.java)
        return PsiTreeUtil.collectElementsOfType(file, LabelDefinitionElement::class.java)
                .firstOrNull { definition -> definition.name == this.name }
    }
}