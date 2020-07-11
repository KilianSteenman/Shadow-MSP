package nl.shadowlink.mission.plugin.psi.opcode

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.PsiFile
import nl.shadowlink.mission.plugin.annotator.Annotatable
import nl.shadowlink.mission.plugin.completion.helpers.GxtProvider
import nl.shadowlink.mission.plugin.completion.helpers.LabelProvider.getLabelCompletions
import nl.shadowlink.mission.plugin.completion.helpers.ModelProvider
import nl.shadowlink.mission.plugin.completion.helpers.VariableProvider
import nl.shadowlink.mission.plugin.game.opcodes.Opcode
import nl.shadowlink.mission.plugin.game.opcodes.OpcodeDatabaseFactory
import nl.shadowlink.mission.plugin.game.opcodes.OpcodeParam
import nl.shadowlink.mission.plugin.lexer.MissionTokenType

class OpcodeExpression(node: ASTNode) : ASTWrapperPsiElement(node), Annotatable {

    override fun annotate(holder: AnnotationHolder) {
        val opcodeText = node.findChildByType(MissionTokenType.OPCODE)
        val params = node.getChildren(MissionTokenType.OPCODE_PARAM_TYPES)

        val opcode = getOpcodeInfo()
        if (opcode == null) {
            holder.createErrorAnnotation(this, "Unknown opcode $opcodeText")
        } else {
            if (!isParamCountCorrect(opcode, params.size)) {
                holder.createErrorAnnotation(this, "Expected ${opcode.paramCount} params")
            }
        }
    }

    private fun getOpcode(): String {
        return node.findChildByType(MissionTokenType.OPCODE)?.text?.substring(0, 4) ?: ""
    }

    private fun getOpcodeInfo(): Opcode? {
        return OpcodeDatabaseFactory.getDatabase().opcode(getOpcode())
    }

    private fun isParamCountCorrect(opcode: Opcode, paramCount: Int): Boolean {
        return if (opcode.opcode == "00D6") {
            opcode.opcode == "00D6" && paramCount == 0 || opcode.paramCount == paramCount
        } else {
            opcode.paramCount == paramCount
        }
    }

    private fun getCurrentParamCount(): Int {
        return node.getChildren(MissionTokenType.OPCODE_PARAM_TYPES).size
    }

    fun getCompletion(file: PsiFile): List<LookupElement> {
        val opcode = getOpcodeInfo() ?: return emptyList()

        val paramCount = getCurrentParamCount()
        val paramToComplete = opcode.params.getOrNull(paramCount)
        if (paramToComplete != null) {
            return when (paramToComplete) {
                OpcodeParam.ANY -> emptyList()
                OpcodeParam.STRING -> emptyList()
                OpcodeParam.INT -> VariableProvider.provideAll(file)
                OpcodeParam.FLOAT -> VariableProvider.provideAll(file)
                OpcodeParam.GXT_REF -> GxtProvider.provide(file)
                OpcodeParam.LABEL_REF -> getLabelCompletions(file)
                OpcodeParam.MODEL -> ModelProvider.provide(file)
            }
        }
        return emptyList()
    }
}