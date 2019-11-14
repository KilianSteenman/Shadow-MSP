package nl.shadowlink.mission.plugin.psi.opcode

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.annotation.AnnotationHolder
import nl.shadowlink.mission.plugin.annotator.Annotatable
import nl.shadowlink.mission.plugin.game.opcodes.Opcode
import nl.shadowlink.mission.plugin.game.opcodes.OpcodeDatabaseFactory
import nl.shadowlink.mission.plugin.lexer.MissionTokenType

class OpcodeExpression(node: ASTNode) : ASTWrapperPsiElement(node), Annotatable {

    override fun annotate(holder: AnnotationHolder) {
        val opcodeText = node.findChildByType(MissionTokenType.OPCODE)
        val params = node.getChildren(MissionTokenType.OPCODE_PARAM_TYPES)

        val opcode = OpcodeDatabaseFactory.getDatabase().opcode(opcodeText?.text?.substring(0, 4))
        if (opcode == null) {
            holder.createErrorAnnotation(this, "Unknown opcode $opcodeText")
        } else {
            if (!isParamCountCorrect(opcode, params.size)) {
                holder.createErrorAnnotation(this, "Expected ${opcode.paramCount} params")
            }
        }
    }

    private fun isParamCountCorrect(opcode: Opcode, paramCount: Int): Boolean {
        return if (opcode.opcode == "00D6") {
            opcode.opcode == "00D6" && paramCount == 0 || opcode.paramCount == paramCount
        } else {
            opcode.paramCount == paramCount
        }
    }
}