package nl.shadowlink.mission.plugin.gta3d.psi.params

import com.intellij.lang.ASTNode
import nl.shadowlink.mission.plugin.gta3d.psi.opcode.OpcodeParameterElement

class FloatElement(node: ASTNode) : OpcodeParameterElement(node) {

    val value: Int get() = node.text.toInt()
}