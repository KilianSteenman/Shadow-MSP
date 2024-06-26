package nl.shadowlink.mission.plugin.gta3d.highlighter

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import nl.shadowlink.mission.plugin.gta3d.lexer.MissionLexer
import nl.shadowlink.mission.plugin.gta3d.lexer.MissionTokenType

class MissionHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        return if (tokenType is MissionTokenType) {
            when (tokenType) {
                MissionTokenType.STRING -> arrayOf(MissionColor.STRING.attributesKey)
                MissionTokenType.STRING_KEY -> arrayOf(MissionColor.STRING.attributesKey)
                MissionTokenType.COMMENT -> arrayOf(MissionColor.LINE_COMMENT.attributesKey)
                MissionTokenType.MODEL -> arrayOf(MissionColor.CONSTANT.attributesKey)
                MissionTokenType.INT -> arrayOf(MissionColor.NUMBER.attributesKey)
                MissionTokenType.FLOAT -> arrayOf(MissionColor.NUMBER.attributesKey)
                MissionTokenType.LABEL -> arrayOf(MissionColor.LABEL.attributesKey)
                MissionTokenType.LABEL_REF -> arrayOf(MissionColor.LABEL_REF.attributesKey)
                MissionTokenType.GLOBAL_VAR -> arrayOf(MissionColor.GLOBAL_VAR.attributesKey)
                MissionTokenType.LOCAL_VAR -> arrayOf(MissionColor.LOCAL_VAR.attributesKey)
                MissionTokenType.KEY_DEFINE -> arrayOf(MissionColor.KEYWORD.attributesKey)
                MissionTokenType.KEY_OBJECT -> arrayOf(MissionColor.KEYWORD.attributesKey)
                MissionTokenType.KEY_OBJECTS -> arrayOf(MissionColor.KEYWORD.attributesKey)
                MissionTokenType.KEY_MISSION -> arrayOf(MissionColor.KEYWORD.attributesKey)
                MissionTokenType.KEY_MISSIONS -> arrayOf(MissionColor.KEYWORD.attributesKey)
                else -> emptyArray()
            }
        } else {
            emptyArray()
        }
    }

    override fun getHighlightingLexer(): Lexer = MissionLexer()
}