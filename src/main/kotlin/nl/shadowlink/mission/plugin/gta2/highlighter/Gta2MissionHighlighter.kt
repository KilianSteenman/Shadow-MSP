package nl.shadowlink.mission.plugin.gta2.highlighter

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import nl.shadowlink.mission.plugin.gta2.psi.Gta2MissionTokenType
import nl.shadowlink.mission.plugin.lexer.MissionLexer
import nl.shadowlink.mission.plugin.lexer.MissionTokenType

class Gta2MissionHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        return if (tokenType is Gta2MissionTokenType) {
//            when (tokenType) {
//                MissionTokenType.STRING -> arrayOf(Gta2MissionColor.STRING.attributesKey)
//                MissionTokenType.STRING_KEY -> arrayOf(Gta2MissionColor.STRING.attributesKey)
//                MissionTokenType.COMMENT -> arrayOf(Gta2MissionColor.LINE_COMMENT.attributesKey)
//                MissionTokenType.MODEL -> arrayOf(Gta2MissionColor.CONSTANT.attributesKey)
//                MissionTokenType.INT -> arrayOf(Gta2MissionColor.NUMBER.attributesKey)
//                MissionTokenType.FLOAT -> arrayOf(Gta2MissionColor.NUMBER.attributesKey)
//                MissionTokenType.LABEL -> arrayOf(Gta2MissionColor.LABEL.attributesKey)
//                MissionTokenType.LABEL_REF -> arrayOf(Gta2MissionColor.LABEL_REF.attributesKey)
//                MissionTokenType.GLOBAL_VAR -> arrayOf(Gta2MissionColor.GLOBAL_VAR.attributesKey)
//                MissionTokenType.LOCAL_VAR -> arrayOf(Gta2MissionColor.LOCAL_VAR.attributesKey)
//                MissionTokenType.KEY_DEFINE -> arrayOf(Gta2MissionColor.KEYWORD.attributesKey)
//                MissionTokenType.KEY_OBJECT -> arrayOf(Gta2MissionColor.KEYWORD.attributesKey)
//                MissionTokenType.KEY_OBJECTS -> arrayOf(Gta2MissionColor.KEYWORD.attributesKey)
//                MissionTokenType.KEY_MISSION -> arrayOf(Gta2MissionColor.KEYWORD.attributesKey)
//                MissionTokenType.KEY_MISSIONS -> arrayOf(Gta2MissionColor.KEYWORD.attributesKey)
//                else -> emptyArray()
//            }
            emptyArray()
        } else {
            emptyArray()
        }
    }

    override fun getHighlightingLexer(): Lexer = MissionLexer()
}