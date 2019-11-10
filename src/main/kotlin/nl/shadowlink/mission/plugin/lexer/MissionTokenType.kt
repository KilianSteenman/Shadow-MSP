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
        GLOBAL_VAR,
        GLOBAL_VAR_DEF,
        GLOBAL_VAR_REF,
        LOCAL_VAR,
        LOCAL_VAR_REF,
        LOCAL_VAR_DEF,
        FLOAT,
        INT,
        EQUAL,
        EQUALS,
        KEY_DEFINE,
        KEY_MISSIONS,
        KEY_MISSION,
        KEY_OBJECTS,
        KEY_OBJECT,
        OPCODE_TEXT
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
        val GLOBAL_VAR = MissionTokenType(Type.GLOBAL_VAR)
        val GLOBAL_VAR_DEF = MissionTokenType(Type.GLOBAL_VAR_DEF)
        val GLOBAL_VAR_REF = MissionTokenType(Type.GLOBAL_VAR_REF)
        val LOCAL_VAR = MissionTokenType(Type.LOCAL_VAR)
        val LOCAL_VAR_REF = MissionTokenType(Type.LOCAL_VAR_REF)
        val LOCAL_VAR_DEF = MissionTokenType(Type.LOCAL_VAR_DEF)
        val FLOAT = MissionTokenType(Type.FLOAT)
        val INT = MissionTokenType(Type.INT)
        val EQUALS = MissionTokenType(Type.EQUALS)
        val EQUAL = MissionTokenType(Type.EQUAL)
        val KEY_DEFINE = MissionTokenType(Type.KEY_DEFINE)
        val KEY_MISSIONS = MissionTokenType(Type.KEY_MISSIONS)
        val KEY_MISSION = MissionTokenType(Type.KEY_MISSION)
        val KEY_OBJECTS = MissionTokenType(Type.KEY_OBJECTS)
        val KEY_OBJECT = MissionTokenType(Type.KEY_OBJECT)
        val OPCODE_TEXT = MissionTokenType(Type.OPCODE_TEXT)

        val WHITE_SPACE_TYPES = TokenSet.create(SPACE)
        val COMMENT_TYPES = TokenSet.create(COMMENT)
        val STRING_TYPES = TokenSet.create(STRING_KEY, STRING)
        val LABEL_TYPES = TokenSet.create(LABEL, LABEL_REF)

        val KEYWORD_TYPES = TokenSet.create(
                KEY_DEFINE, KEY_MISSIONS, KEY_MISSION, KEY_OBJECTS, KEY_OBJECT
        )

        val OPCODE_EXPRESSION_TYPES = TokenSet.create(
                OPCODE_TEXT, STRING_KEY, STRING, MODEL, FLOAT, INT, EQUAL, EQUALS, GLOBAL_VAR, LABEL_REF, LOCAL_VAR
        )

        val OPCODE_PARAM_TYPES = TokenSet.create(
                FLOAT, INT, MODEL, LOCAL_VAR_DEF, LOCAL_VAR_REF, GLOBAL_VAR_DEF, GLOBAL_VAR_REF, STRING, STRING_KEY, LABEL_REF
        )
    }
}