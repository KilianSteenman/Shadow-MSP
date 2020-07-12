package nl.shadowlink.mission.plugin.psi.opcode

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.util.parentOfType
import nl.shadowlink.mission.plugin.annotator.Annotatable
import nl.shadowlink.mission.plugin.game.opcodes.Opcode
import nl.shadowlink.mission.plugin.game.opcodes.OpcodeDatabaseFactory

open class OpcodeParameterElement(node: ASTNode) : ASTWrapperPsiElement(node), Annotatable {

    override fun annotate(holder: AnnotationHolder) {
        val opcode = getOpcodeInfo()
        holder.createInfoAnnotation(this, "${opcode?.paramInfo()}")
    }

    private fun getOpcodeInfo(): Opcode? {
        return parentOfType(OpcodeExpression::class)?.getOpcodeInfo()
    }
}