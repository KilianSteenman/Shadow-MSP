package nl.shadowlink.mission.plugin.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.annotation.AnnotationHolder

class StringElement(node: ASTNode) : ASTWrapperPsiElement(node) {

    private val value get() = node.text.substring(1, node.textLength - 1)

    private val valueLength get() = value.length

    fun annotate(holder: AnnotationHolder) {
        if(valueLength > 7) {
            holder.createErrorAnnotation(this, "Max length of String is 7")
        }
    }
}