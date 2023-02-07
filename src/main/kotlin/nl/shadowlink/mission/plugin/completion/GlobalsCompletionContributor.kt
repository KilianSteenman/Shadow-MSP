package nl.shadowlink.mission.plugin.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext
import nl.shadowlink.mission.plugin.MissionLanguage
import nl.shadowlink.mission.plugin.lexer.MissionTokenType
import nl.shadowlink.mission.plugin.psi.findGlobalDefinitions

class GlobalsCompletionContributor : CompletionContributor() {

    init {
        extend(
            CompletionType.BASIC, PlatformPatterns.psiElement(MissionTokenType.GLOBAL_VAR)
                .andOr(PlatformPatterns.psiElement(MissionTokenType.GLOBAL_VAR))
                .withLanguage(MissionLanguage),
            GlobalsCompletionProvider()
        )
    }
}

private class GlobalsCompletionProvider : CompletionProvider<CompletionParameters>() {

    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        findGlobalDefinitions(parameters.originalFile.project).forEach { global ->
            result.addElement(LookupElementBuilder.create(global.name))
        }
    }
}