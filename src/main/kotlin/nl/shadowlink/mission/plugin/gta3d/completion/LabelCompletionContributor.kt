package nl.shadowlink.mission.plugin.gta3d.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext
import nl.shadowlink.mission.plugin.gta3d.MissionLanguage
import nl.shadowlink.mission.plugin.gta3d.lexer.MissionTokenType
import nl.shadowlink.mission.plugin.gta3d.psi.findLabelDefinitions

class LabelCompletionContributor : CompletionContributor() {

    init {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(MissionTokenType.LABEL_REF)
                .withLanguage(MissionLanguage),
                LabelCompletionProvider()
        )
    }
}

private class LabelCompletionProvider : CompletionProvider<CompletionParameters>() {

    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
        findLabelDefinitions(parameters.originalFile).forEach { labelDefinition ->
            result.addElement(LookupElementBuilder.create(labelDefinition.name))
        }
    }
}