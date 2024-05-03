package nl.shadowlink.mission.plugin.gta2.highlighter

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import nl.shadowlink.mission.plugin.gta2.Gta2LexerAdapter
import nl.shadowlink.mission.plugin.gta2.psi.Gta2MissionTokenSets.KEYWORDS
import nl.shadowlink.mission.plugin.gta2.psi.Gta2MissionTypes

class Gta2MissionHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        return when {
            KEYWORDS.contains(tokenType) -> arrayOf(Gta2MissionColor.KEYWORD.attributesKey)
            tokenType == Gta2MissionTypes.COMMENT -> arrayOf(Gta2MissionColor.LINE_COMMENT.attributesKey)
            tokenType == Gta2MissionTypes.COMMENT_BLOCK -> arrayOf(Gta2MissionColor.BLOCK_COMMENT.attributesKey)
            tokenType == Gta2MissionTypes.NUMBER -> arrayOf(Gta2MissionColor.NUMBER.attributesKey)
            tokenType == Gta2MissionTypes.SUBROUTINE_DEFINITION -> arrayOf(Gta2MissionColor.SUBROUTINE_DECLARATION.attributesKey)
            tokenType == Gta2MissionTypes.SUBROUTINE -> arrayOf(Gta2MissionColor.SUBROUTINE_REFERENCE.attributesKey)
            else -> emptyArray()
        }
    }

    override fun getHighlightingLexer(): Lexer = Gta2LexerAdapter()
}