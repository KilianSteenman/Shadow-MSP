package nl.shadowlink.mission.plugin.gta3d.lexer

import com.intellij.psi.tree.IElementType
import nl.shadowlink.mission.plugin.gta3d.MissionLanguage

class MissionExpressionType(type: Type) : IElementType(type.name, MissionLanguage) {

    enum class Type {
        DEFINE_MISSION_COUNT,
        DEFINE_MISSION,
        DEFINE_OBJECT_COUNT,
        DEFINE_OBJECT,
        OPCODE_EXPRESSION
    }

    companion object {
        val DEFINE_MISSION_COUNT = MissionExpressionType(Type.DEFINE_MISSION_COUNT)
        val DEFINE_MISSION = MissionExpressionType(Type.DEFINE_MISSION)
        val DEFINE_OBJECT_COUNT = MissionExpressionType(Type.DEFINE_OBJECT_COUNT)
        val DEFINE_OBJECT = MissionExpressionType(Type.DEFINE_OBJECT)
        val OPCODE_EXPRESSION = MissionExpressionType(Type.OPCODE_EXPRESSION)
    }
}