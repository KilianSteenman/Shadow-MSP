package nl.shadowlink.mission.plugin.gta3script.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.psi.PsiElement
import com.intellij.util.ProcessingContext
import com.jetbrains.rd.util.string.print
import nl.shadowlink.mission.plugin.MissionIcons
import nl.shadowlink.mission.plugin.utils.logWarn
import nl.shadowlink.mission.plugin.gta3d.game.opcodes.Opcode
import nl.shadowlink.mission.plugin.gta3d.game.opcodes.OpcodeDatabase
import nl.shadowlink.mission.plugin.gta3d.game.opcodes.OpcodeDatabaseFactory
import nl.shadowlink.mission.plugin.gta3script.Gta3ScriptLanguage
import kotlin.math.log

class OpcodeCompletionContributor : CompletionContributor() {

    private val opcodeDatabase = OpcodeDatabaseFactory.getDatabase()

    init {
        extend(
            CompletionType.BASIC,
            psiElement().withLanguage(Gta3ScriptLanguage),
            OpcodeCompletionProvider(opcodeDatabase)
        )
    }
}

private class OpcodeCompletionProvider(
    private val opcodeDatabase: OpcodeDatabase
) : CompletionProvider<CompletionParameters>() {

    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        println("Completion ${parameters.position.printTree()}")
        opcodeDatabase.opcodes.forEach { opcode ->
            result.addElement(opcode.toLookupElement())
        }
    }

    private fun PsiElement.printTree(): String {
        return "${this.parent?.printTree()}->$this"
    }

    private fun Opcode.toLookupElement(): LookupElement {
        return LookupElementBuilder.create(format)
            .withBaseLookupString(format)
            .withLookupString(format.lowercase())
            .withPresentableText(format.trim())
            .appendTailText("(${opcode})", true)
            .withTypeText("Opcode")
            .withIcon(MissionIcons.FILE)
            .withInsertHandler(OpcodeInsertionHandler(this))
    }
}

class OpcodeInsertionHandler(
    private val opcode: Opcode
) : InsertHandler<LookupElement> {

    override fun handleInsert(context: InsertionContext, item: LookupElement) {
//        val document: Document = context.document
//        val editor: Editor = context.editor
//        val file: PsiFile = context.file
//        val startOffset: Int = context.startOffset
//        val caretModel: CaretModel = editor.caretModel

        // Insert the method call with placeholders for parameters
        val commandCall = if (opcode.paramCount > 0) {
            "${opcode.format} "
        } else {
            opcode.format
        }
        context.document.replaceString(context.startOffset, context.tailOffset, commandCall)

        // Move the caret inside the first parameter placeholder
        val firstParamStart = //methodCall.indexOf("{") + context.startOffset
            context.editor.caretModel.moveToOffset(context.tailOffset)
//        logWarn("Inserting: $item")
    }
}