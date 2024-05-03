package nl.shadowlink.mission.plugin.gta3d.game.opcodes

data class OpcodeParam(
        val type: ParamType,
        val description: String?
)

enum class ParamType {
    STRING, INT, FLOAT, GXT_REF, LABEL_REF, MODEL, ANY
}