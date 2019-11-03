package nl.shadowlink.mission.plugin.psi.local

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

abstract class LocalVarElement(node: ASTNode) : ASTWrapperPsiElement(node) {

    override fun getName(): String? {
        return node.text.substringBefore('@')
    }
}