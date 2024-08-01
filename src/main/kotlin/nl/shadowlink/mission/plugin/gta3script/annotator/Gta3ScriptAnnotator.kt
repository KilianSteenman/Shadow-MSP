package nl.shadowlink.mission.plugin.gta3script.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.lang.annotation.ProblemGroup
import com.intellij.psi.PsiElement
import nl.shadowlink.mission.plugin.gta3d.game.opcodes.Opcode
import nl.shadowlink.mission.plugin.gta3d.game.opcodes.OpcodeDatabaseFactory
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptLabel
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptMethodCall
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptParam
import nl.shadowlink.mission.plugin.gta3script.psi.findLabelDeclaration
import nl.shadowlink.mission.plugin.utils.findChildrenOfType

class Gta3ScriptAnnotator : Annotator {

    private val opcodeDatabase = OpcodeDatabaseFactory.getDatabase()

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is Gta3ScriptLabel -> annotateLabel(element, holder)
            is Gta3ScriptMethodCall -> annotateMethodCall(element, holder)
        }
    }

    private fun annotateLabel(label: Gta3ScriptLabel, holder: AnnotationHolder) {
        if (label.project.findLabelDeclaration(label.name) == null) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Unresolved label")
                .create()
        }
    }

    private fun annotateMethodCall(methodCall: Gta3ScriptMethodCall, holder: AnnotationHolder) {
        val commandName = methodCall.methodName.text
        val opcode = opcodeDatabase.getOpcodeByName(commandName)
        if (opcode == null) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Command '$commandName' not found")
                .create()
        } else {
            val params = methodCall.getParams()
            if (params.size > opcode.paramCount) {
                holder.newAnnotation(HighlightSeverity.ERROR, "Too many arguments for $commandName")
                    .create()
            } else if (params.size < opcode.paramCount) {
                holder.newAnnotation(
                    HighlightSeverity.ERROR,
                    "Not enough arguments for $commandName\nExpected ${opcode.toExpectedFormat()}"
                ).create()
            }
        }
    }

    private fun Opcode.toExpectedFormat(): String {
        val paramFormat = this.params.map { it.type }.joinToString(", ")
        return "${this.format} $paramFormat"
    }

    private fun Gta3ScriptMethodCall.getParams(): List<String> {
        return this.findChildrenOfType<Gta3ScriptParam>().map { it.text }
    }
}