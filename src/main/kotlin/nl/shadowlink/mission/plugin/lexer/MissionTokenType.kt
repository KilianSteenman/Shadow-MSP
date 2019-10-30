package nl.shadowlink.mission.plugin.lexer

import com.intellij.psi.tree.IElementType
import nl.shadowlink.mission.plugin.MissionLanguage
import com.intellij.psi.tree.TokenSet

class MissionTokenType(type: Type) : IElementType(type.name, MissionLanguage) {

    enum class Type {
        OPCODE,
        LABEL,
        SPACE,
        INLINE_COMMENT,
        STRING,
        STRING_KEY,
        MODEL,
        ERROR,
        SYMBOL,
        FLOAT,
        INT,
        DEFINE
    }

    companion object {
        val OPCODE = MissionTokenType(Type.OPCODE)
        val LABEL = MissionTokenType(Type.LABEL)
        val LABEL_REF = MissionTokenType(Type.LABEL)
        val SPACE = MissionTokenType(Type.SPACE)
        val COMMENT = MissionTokenType(Type.INLINE_COMMENT)
        val STRING_KEY = MissionTokenType(Type.STRING_KEY)
        val STRING = MissionTokenType(Type.STRING)
        val MODEL = MissionTokenType(Type.MODEL)
        val ERROR = MissionTokenType(Type.ERROR)
        val SYMBOL = MissionTokenType(Type.SYMBOL)
        val FLOAT = MissionTokenType(Type.FLOAT)
        val INT = MissionTokenType(Type.INT)
        val DEFINE = MissionTokenType(Type.DEFINE)

        val WHITE_SPACE_TYPES = TokenSet.create(SPACE)
        val COMMENT_TYPES = TokenSet.create(COMMENT)
        val STRING_TYPES = TokenSet.create(STRING_KEY, STRING)
        val LABEL_TYPES = TokenSet.create(LABEL, LABEL_REF)
    }
}