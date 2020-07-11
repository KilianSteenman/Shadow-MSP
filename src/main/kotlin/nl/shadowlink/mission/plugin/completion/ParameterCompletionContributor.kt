package nl.shadowlink.mission.plugin.completion

import com.intellij.codeInsight.completion.*
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext
import nl.shadowlink.mission.plugin.MissionLanguage
import nl.shadowlink.mission.plugin.lexer.MissionTokenType
import nl.shadowlink.mission.plugin.psi.opcode.OpcodeExpression

class ParameterCompletionContributor : CompletionContributor() {

    init {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(MissionTokenType.OPCODE_TEXT)
                .withLanguage(MissionLanguage),
                ParameterCompletionProvider()
        )
    }
}

private class ParameterCompletionProvider : CompletionProvider<CompletionParameters>() {

    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
        val element = parameters.position.parent.parent
        if (element is OpcodeExpression) {
            element.getCompletion(parameters.originalFile).forEach { result.addElement(it) }
        }
    }
}