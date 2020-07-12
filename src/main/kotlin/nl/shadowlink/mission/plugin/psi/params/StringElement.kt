package nl.shadowlink.mission.plugin.psi.params

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import nl.shadowlink.mission.plugin.psi.opcode.OpcodeParameterElement

class StringElement(node: ASTNode) : OpcodeParameterElement(node)