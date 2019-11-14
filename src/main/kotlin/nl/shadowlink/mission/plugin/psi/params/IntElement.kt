package nl.shadowlink.mission.plugin.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

class IntElement(node: ASTNode) : ASTWrapperPsiElement(node) {

    val value: Int get() = node.text.toInt()
}