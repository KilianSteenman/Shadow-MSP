package nl.shadowlink.mission.plugin.gta3d.psi.opcode

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.annotation.AnnotationHolder
import nl.shadowlink.mission.plugin.gta3d.annotator.Annotatable
import nl.shadowlink.mission.plugin.gta3d.game.opcodes.OpcodeDatabaseFactory

class OpcodeElement(node: ASTNode) : ASTWrapperPsiElement(node), Annotatable {

    private val opcode: String get() = text.substring(0, 4)

    override fun annotate(holder: AnnotationHolder) {
        if(!OpcodeDatabaseFactory.getDatabase().isOpcodeValid(opcode)) {
            holder.createErrorAnnotation(this, "Unknown opcode")
        }
    }
}