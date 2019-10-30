package nl.shadowlink.mission.plugin.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.annotation.AnnotationHolder
import nl.shadowlink.mission.plugin.annotator.Annotatable
import nl.shadowlink.mission.plugin.game.opcodes.OpcodeDatabaseFactory

class OpcodeElement(node: ASTNode) : ASTWrapperPsiElement(node), Annotatable {

    private val opcode: String get() = text.substring(0, textLength - 1)

    override fun annotate(holder: AnnotationHolder) {
        if(!OpcodeDatabaseFactory.getDatabase().isOpcodeValid(opcode)) {
            holder.createErrorAnnotation(this, "Unknown opcode")
        }
    }
}