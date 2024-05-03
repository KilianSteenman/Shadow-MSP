package nl.shadowlink.mission.plugin.gta3d.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext
import nl.shadowlink.mission.plugin.gta3d.MissionLanguage
import nl.shadowlink.mission.plugin.gta3d.game.models.ModelNameProvider
import nl.shadowlink.mission.plugin.gta3d.lexer.MissionTokenType

class ModelCompletionContributor : CompletionContributor() {

    private val modelNameProvider = ModelNameProvider()

    init {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(MissionTokenType.MODEL)
                .withLanguage(MissionLanguage),
                object : CompletionProvider<CompletionParameters>() {
                    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
                        modelNameProvider.models
                                .forEach { model -> result.addElement(LookupElementBuilder.create(model)) }
                    }
                }
        )
    }
}