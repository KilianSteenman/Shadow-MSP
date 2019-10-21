package nl.shadowlink.mission.plugin.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

class DefaultElement(node: ASTNode): ASTWrapperPsiElement(node)