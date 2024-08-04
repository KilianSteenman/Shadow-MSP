package nl.shadowlink.mission.plugin.gta3script.documentation

import com.intellij.lang.documentation.AbstractDocumentationProvider
import com.intellij.lang.documentation.DocumentationMarkup
import com.intellij.psi.PsiElement
import nl.shadowlink.mission.plugin.gta3d.game.opcodes.OpcodeDatabaseFactory
import nl.shadowlink.mission.plugin.gta3d.game.opcodes.OpcodeParam
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptMethodName

internal class Gta3ScriptDocumentation : AbstractDocumentationProvider() {

    private val opcodeDatabase = OpcodeDatabaseFactory.getDatabase()

    override fun generateDoc(element: PsiElement?, originalElement: PsiElement?): String? {
        if (element is Gta3ScriptMethodName) {
            return generateMethodDoc(element)
        }
        return super.generateDoc(element, originalElement)
    }

    private fun generateMethodDoc(element: Gta3ScriptMethodName): String? {
        val opcode = opcodeDatabase.getOpcodeByName(element.text) ?: return null

        return StringBuilder().apply {
            append(DocumentationMarkup.DEFINITION_START)
            append("Script Command")
            append(DocumentationMarkup.DEFINITION_END)
            opcode.description?.let {
                append(DocumentationMarkup.CONTENT_START)
                append(opcode.description)
                append(DocumentationMarkup.CONTENT_END)
            }
            append(DocumentationMarkup.SECTIONS_START)
            if (opcode.paramCount > 0) {
                addKeyValueSection("Params:", formatParams(opcode.params))
            }
            addKeyValueSection("Opcode: ", opcode.opcode)
            append(DocumentationMarkup.SECTIONS_END)
        }.toString()
    }

    private companion object {

        private fun formatParams(params: List<OpcodeParam>) =
            params.joinToString("<br/>") { param ->
                if (param.description != null) {
                    "${param.type.name} - ${param.description}"
                } else {
                    param.type.name
                }
            }

        private fun StringBuilder.addKeyValueSection(key: String, value: String) {
            append(DocumentationMarkup.SECTION_HEADER_START)
            append(key)
            append(DocumentationMarkup.SECTION_SEPARATOR)
            append("<p>")
            append(value)
            append(DocumentationMarkup.SECTION_END)
        }
    }
}