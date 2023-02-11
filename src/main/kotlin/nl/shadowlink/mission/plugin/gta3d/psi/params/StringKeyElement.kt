package nl.shadowlink.mission.plugin.gta3d.psi.params

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.annotation.AnnotationHolder
import nl.shadowlink.mission.plugin.gta3d.annotator.Annotatable
import nl.shadowlink.mission.plugin.gta3d.psi.opcode.OpcodeParameterElement

class StringKeyElement(node: ASTNode) : OpcodeParameterElement(node), Annotatable {

    private val value get() = node.text.substring(1, node.textLength - 1)

    private val valueLength get() = value.length

    override fun annotate(holder: AnnotationHolder) {
        if(valueLength > 7) {
            holder.createErrorAnnotation(this, "Max length of String is 7")
        }
    }
}