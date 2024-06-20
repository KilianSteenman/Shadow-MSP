package nl.shadowlink.mission.plugin.gta3script.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.TokenType
import com.intellij.psi.impl.source.tree.PsiWhiteSpaceImpl
import com.intellij.util.ProcessingContext
import nl.shadowlink.mission.plugin.MissionIcons
import nl.shadowlink.mission.plugin.gta3d.MissionLanguage
import nl.shadowlink.mission.plugin.utils.logWarn
import nl.shadowlink.mission.plugin.gta3d.game.opcodes.Opcode
import nl.shadowlink.mission.plugin.gta3d.game.opcodes.OpcodeDatabase
import nl.shadowlink.mission.plugin.gta3d.game.opcodes.OpcodeDatabaseFactory
import nl.shadowlink.mission.plugin.gta3d.lexer.MissionTokenType
import nl.shadowlink.mission.plugin.gta3script.Gta3ScriptLanguage
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptTokenType
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptTypes

class OpcodeCompletionContributor : CompletionContributor() {

//    private val opcodeDatabase = OpcodeDatabaseFactory.getDatabase()

    init {
        extend(
            CompletionType.BASIC,
            psiElement(Gta3ScriptTypes.NEW_LINE).withLanguage(Gta3ScriptLanguage),
            OpcodeCompletionProvider()
        )
    }
}

private class OpcodeCompletionProvider(
//    private val opcodeDatabase: OpcodeDatabase
) : CompletionProvider<CompletionParameters>() {

    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        result.addElement(
            LookupElementBuilder.create("create")
                .withPresentableText("presentable")
                .withTypeText("type")
                .withIcon(MissionIcons.FILE)
//                .withInsertHandler(OpcodeInsertionHandler)
        )
//        opcodeDatabase.opcodes.forEach { opcode -> result.addElement(opcode.toLookupElement()) }
    }

    private fun Opcode.toLookupElement(): LookupElement {
        return LookupElementBuilder.create("$opcode: $format ")
            .withPresentableText(format.trim())
            .withTypeText("Opcode $opcode")
            .withIcon(MissionIcons.FILE)
            .withInsertHandler(OpcodeInsertionHandler)
    }
}

object OpcodeInsertionHandler : InsertHandler<LookupElement> {

    override fun handleInsert(context: InsertionContext, item: LookupElement) {
        logWarn("Inserting: $item")
    }
}