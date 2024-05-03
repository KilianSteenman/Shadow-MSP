package nl.shadowlink.mission.plugin.gta3script.highlighter

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import nl.shadowlink.mission.plugin.gta3script.Gta3ScriptLexerAdapter
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptTokenSets.KEYWORDS
import nl.shadowlink.mission.plugin.gta3script.psi.Gta3ScriptTypes

class Gta3ScriptHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        return when {
            KEYWORDS.contains(tokenType) -> arrayOf(Gta3ScriptColor.KEYWORD.attributesKey)
            tokenType == Gta3ScriptTypes.COMMENT -> arrayOf(Gta3ScriptColor.LINE_COMMENT.attributesKey)
            tokenType == Gta3ScriptTypes.NUMBER -> arrayOf(Gta3ScriptColor.NUMBER.attributesKey)
            tokenType == Gta3ScriptTypes.LABEL_IDENTIFIER -> arrayOf(Gta3ScriptColor.SUBROUTINE_DECLARATION.attributesKey)
            tokenType == Gta3ScriptTypes.SUBROUTINE -> arrayOf(Gta3ScriptColor.SUBROUTINE_REFERENCE.attributesKey)
            else -> emptyArray()
        }
    }

    override fun getHighlightingLexer(): Lexer = Gta3ScriptLexerAdapter()
}