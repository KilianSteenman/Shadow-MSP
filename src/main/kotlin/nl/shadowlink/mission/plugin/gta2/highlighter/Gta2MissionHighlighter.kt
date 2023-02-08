package nl.shadowlink.mission.plugin.gta2.highlighter

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import nl.shadowlink.mission.plugin.gta2.Gta2LexerAdapter
import nl.shadowlink.mission.plugin.gta2.psi.Gta2MissionTypes

class Gta2MissionHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        return when (tokenType) {
            Gta2MissionTypes.COMMENT -> arrayOf(Gta2MissionColor.LINE_COMMENT.attributesKey)
            Gta2MissionTypes.NUMBER -> arrayOf(Gta2MissionColor.NUMBER.attributesKey)
            Gta2MissionTypes.SUBROUTINE_DEFINITION -> arrayOf(Gta2MissionColor.SUBROUTINE_DECLARATION.attributesKey)
            Gta2MissionTypes.SUBROUTINE -> arrayOf(Gta2MissionColor.SUBROUTINE_REFERENCE.attributesKey)
            else -> emptyArray()
        }
    }

    override fun getHighlightingLexer(): Lexer = Gta2LexerAdapter()
}