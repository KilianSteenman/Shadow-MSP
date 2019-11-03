package nl.shadowlink.mission.plugin.psi.global

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

abstract class GlobalVarElement(node: ASTNode) : ASTWrapperPsiElement(node) {

    override fun getName(): String {
        return node.text.substring(1)
    }
}