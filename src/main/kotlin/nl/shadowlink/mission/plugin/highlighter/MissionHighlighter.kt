package nl.shadowlink.mission.plugin.highlighter

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import nl.shadowlink.mission.plugin.lexer.MissionLexer
import nl.shadowlink.mission.plugin.lexer.MissionTokenType

class MissionHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        return when (tokenType as MissionTokenType) {
            MissionTokenType.STRING -> arrayOf(DefaultLanguageHighlighterColors.STRING)
            MissionTokenType.COMMENT -> arrayOf(DefaultLanguageHighlighterColors.LINE_COMMENT)
            MissionTokenType.MODEL -> arrayOf(DefaultLanguageHighlighterColors.CONSTANT)
            MissionTokenType.INT -> arrayOf(DefaultLanguageHighlighterColors.NUMBER)
            MissionTokenType.FLOAT -> arrayOf(DefaultLanguageHighlighterColors.NUMBER)
            MissionTokenType.LABEL -> arrayOf(DefaultLanguageHighlighterColors.FUNCTION_DECLARATION)
            MissionTokenType.LABEL_REF -> arrayOf(DefaultLanguageHighlighterColors.FUNCTION_CALL)
            MissionTokenType.SYMBOL -> arrayOf(DefaultLanguageHighlighterColors.GLOBAL_VARIABLE)
            else -> emptyArray()
        }
    }

    override fun getHighlightingLexer(): Lexer = MissionLexer()
}