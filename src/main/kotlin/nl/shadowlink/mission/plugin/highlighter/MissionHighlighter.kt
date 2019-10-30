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
        return if (tokenType is MissionTokenType) {
            when (tokenType) {
                MissionTokenType.STRING -> arrayOf(MissionColor.STRING.attributesKey)
                MissionTokenType.STRING_KEY -> arrayOf(MissionColor.STRING.attributesKey)
                MissionTokenType.COMMENT -> arrayOf(MissionColor.LINE_COMMENT.attributesKey)
                MissionTokenType.MODEL -> arrayOf(DefaultLanguageHighlighterColors.CONSTANT)
                MissionTokenType.INT -> arrayOf(MissionColor.NUMBER.attributesKey)
                MissionTokenType.FLOAT -> arrayOf(MissionColor.NUMBER.attributesKey)
                MissionTokenType.LABEL -> arrayOf(DefaultLanguageHighlighterColors.FUNCTION_DECLARATION)
                MissionTokenType.LABEL_REF -> arrayOf(DefaultLanguageHighlighterColors.FUNCTION_CALL)
                MissionTokenType.SYMBOL -> arrayOf(DefaultLanguageHighlighterColors.GLOBAL_VARIABLE)
                MissionTokenType.DEFINE -> arrayOf(DefaultLanguageHighlighterColors.KEYWORD)
                else -> emptyArray()
            }
        } else {
            emptyArray()
        }
    }

    override fun getHighlightingLexer(): Lexer = MissionLexer()
}