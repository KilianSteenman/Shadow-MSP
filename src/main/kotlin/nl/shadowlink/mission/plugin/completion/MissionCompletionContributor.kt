package nl.shadowlink.mission.plugin.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.codeInsight.template.TemplateBuilderFactory
import com.intellij.util.ProcessingContext
import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.impl.source.tree.PsiWhiteSpaceImpl
import nl.shadowlink.mission.plugin.MissionFile
import nl.shadowlink.mission.plugin.MissionIcons
import nl.shadowlink.mission.plugin.MissionLanguage
import nl.shadowlink.mission.plugin.game.models.ModelNameProvider
import nl.shadowlink.mission.plugin.game.opcodes.OpcodeDatabaseFactory
import nl.shadowlink.mission.plugin.lexer.MissionTokenType

class MissionCompletionContributor : CompletionContributor() {

    private val modelNameProvider = ModelNameProvider()

    private val opcodeDatabase = OpcodeDatabaseFactory.getDatabase()

    init {
        extend(CompletionType.BASIC, psiElement(MissionTokenType.MODEL)
                .withLanguage(MissionLanguage),
                object : CompletionProvider<CompletionParameters>() {
                    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
                        modelNameProvider.models()
                                .forEach { model -> result.addElement(LookupElementBuilder.create(model)) }
                    }
                }
        )

        extend(CompletionType.SMART, psiElement()
                .inFile(psiElement(MissionFile::class.java))
                .whitespaceCommentEmptyOrError()
                .withLanguage(MissionLanguage),
                object : CompletionProvider<CompletionParameters>() {
                    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
                        opcodeDatabase.opcodes
                                .forEach { opcode ->
                                    result.addElement(
                                            LookupElementBuilder.create("${opcode.opcode}: ${opcode.format}")
                                                    .withIcon(MissionIcons.FILE)
                                    )
                                }
                    }
                }
        )
    }
}