package nl.shadowlink.mission.plugin.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.codeInsight.template.TemplateBuilderFactory
import com.intellij.util.ProcessingContext
import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.patterns.PlatformPatterns.psiFile
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.impl.source.tree.PsiWhiteSpaceImpl
import nl.shadowlink.mission.plugin.MissionFile
import nl.shadowlink.mission.plugin.MissionIcons
import nl.shadowlink.mission.plugin.MissionLanguage
import nl.shadowlink.mission.plugin.extensions.logWarn
import nl.shadowlink.mission.plugin.game.models.ModelNameProvider
import nl.shadowlink.mission.plugin.game.opcodes.OpcodeDatabaseFactory
import nl.shadowlink.mission.plugin.lexer.MissionTokenType

class OpcodeCompletionContributor : CompletionContributor() {

    private val opcodeDatabase = OpcodeDatabaseFactory.getDatabase()

    init {
        extend(CompletionType.BASIC, psiElement().withLanguage(MissionLanguage),
                object : CompletionProvider<CompletionParameters>() {
                    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
                        opcodeDatabase.opcodes
                                .forEach { opcode ->
                                    result.addElement(
                                            LookupElementBuilder.create("${opcode.opcode}: ${opcode.format}")
                                                    .withPresentableText(opcode.format.trim())
                                                    .withTailText(" ${opcode.opcode}")
                                                    .withIcon(MissionIcons.FILE)
                                                    .withInsertHandler { context, item ->
                                                        logWarn("Inserting: $item")
                                                    }
                                    )
                                }
                    }
                }
        )
    }
}